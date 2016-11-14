<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/top.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<div style="height: 60px;"></div>
	<div class="content-box">
		<div class="col-sm-1 navbar navbar-default navbar-static" id="leftNav">
			<ul class="nav nav-pills nav-stacked" role="tablist" >
				<c:forEach items="${data.consts }" var="var" varStatus="sta">
					<li role="presentation" class="${sta.index==0?'active':''} pointer">
						<a onclick="showData(this)">${var.value }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-sm-11 pull-right">
			<div class="pull-right">
				<div class="pull-left" style="height:50px;line-height:50px;">共找到 <strong id="showInfo"></strong> 记录</div>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" id="chengyu" class="form-control" placeholder="Search">
					</div>
					<button type="button" class="btn btn-default" onclick="toSubmit()">Search</button>
				</form>
			</div>
			<div class="clearfix"></div>
			<div class="panel-group" id="accordion"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		var start = $("#leftNav ul li.active").children().text();
		//加载数据
		loadData("",start);
	});

	function showData(obj) {
		var start = $(obj).text();
		loadData("",start);
		$("#leftNav ul li.active").removeClass("active");
		$(obj).parent().attr("class", "active");
	}

	var mTop = $("#leftNav").offset().top + $("#leftNav").height();
	$(window).scroll(function() {
		var sTop = $(this).scrollTop();//鼠标距离浏览器顶部的距离
		var wTop=document.body.clientHeight;
		if (mTop <= sTop+wTop) {//元素底部的距离 <= 滚动条滚动的距离 + 窗口高度
			$("#leftNav").css({
				"position" : "fixed",
				"bottom" : "0"
			});
		} else {
			$("#leftNav").css({
				"position" : "static"
			});
		}
	});

	/* 	var totalheight = 0; //定义一个总的高度变量
	 $(window).scroll(
	 function() {
	 totalheight = parseFloat($(window).height())
	 + parseFloat($(window).scrollTop()); //浏览器的高度加上滚动条的高度 
	 if ($(document).height() <= totalheight) { //当文档的高度小于或者等于总的高度的时候，开始动态加载数据
	 var start = $("#leftNav li.active").next().children().text();
	 //加载数据
	 if (typeof(start) != "undefined"&&start!=""){
	 loadData(start);
	 }
	
	 }
	 }); */
	 
	 function toSubmit(){
		 var chengyu=$("#chengyu").val();
		 if($.trim(chengyu)!=""){
			 loadData(chengyu,"");
		 }
	 }
	 

	function loadData(chengyu,start,url) {
		var data = "chengyu="+chengyu+"&start="+start;
		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/chengyu/loadData.do",
					data : data,
					async : false,
					success : function(msg) {
						if (msg.responseCode == "0000") {
							$("#accordion").empty();
							if (msg.data != null) {
								var length = msg.data.chengyus.length;
								$("#showInfo").text(length+1);
								if (length > 0) {
									for (var i = 0; i < length; i++) {
										var obj = msg.data.chengyus[i];
										var id = obj.idChengyu;
										var chengyu = obj.chengyu;
										var pinyin = obj.pinyin;
										var diangu = obj.diangu;
										var chuchu = obj.chuchu;
										var lizi = obj.lizi;
										if (diangu == null || diangu == "") {
											diangu = "无";
										}
										if (chuchu == null || chuchu == "") {
											chuchu = "无";
										}
										if (lizi == null || lizi == "") {
											lizi = "无";
										}
										var html = "<div class=\'panel panel-default\'><div class=\'panel-heading\'><h4 class=\'panel-title\'><a data-toggle=\'collapse\' data-parent=\'#accordion\' href=\'#_"+id+"\'> 【"
												+ chengyu
												+ "】 "
												+ pinyin
												+ "</a></h4></div><div id=\'_"+id+"\' class=\'panel-collapse collapse\'><div class=\'panel-body\'>典故："
												+ diangu
												+ "<br/>出处："
												+ chuchu
												+ "<br/>例子："
												+ lizi
												+ "<br/></div></div></div>";

										$("#accordion").append(html);
									}
								} else {
									showMsg("没有相关数据！");
								}
							}
						} else {
							showMsg("加载错误！");
						}
					}
				});
	}
</script>
</html>
