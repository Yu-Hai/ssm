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
		<div class="col-sm-2 navbar navbar-default navbar-static" id="leftNav">
			<ul class="nav nav-pills nav-stacked" role="tablist" >
					<li role="presentation" class="active pointer">
						<a onclick="showData(this)">玩游戏</a>
					</li>
					<li role="presentation" class="active pointer">
						<a onclick="showData(this)">找答案</a>
					</li>
			</ul>
		</div>
		<div class="col-sm-7 pull-left border-normal div-content">
			<div class="col-sm-12 border-normal div-msg">
				<img id="numberA" src="" width="135" height="200" />
				<img id="numberB" src="" width="135" height="200" />
				<img id="numberC" src="" width="135" height="200" />
				<img id="numberD" src="" width="135" height="200"  />
			</div>
			<div id="msgBox"></div>
			
			<div id="solution" class="col-sm-12 border-normal div-solution" contenteditable="true"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#solution").keyup(function() {
		if(event.keyCode == 13) {
			var solution=$("#solution").text();
			alert(solution);
			var data="{solution:"+solution+"}";
			check24PointGameResult(data);
		}
	});

	$(function() {
		general24PointGame();
	});
	
	function check24PointGameResult(data) {
		
		
		alert(encodeURI("(+++---/?)"));
		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/game/check24PointGameResult.do?solution="+encodeURI(data),
					cache:false,
					dataType:"json",
							data : data,
					success : function(msg) {
						if (msg.responseCode == "0000") {
							showMsg(msg.data.msg);
						} else {
							showMsg("加载错误！");
						}
					}
				});
	}
	
	function general24PointGame(){
		$
		.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/game/general24PointGame.do",
			async : false,
			success : function(msg) {
				if (msg.responseCode == "0000") {
					if (msg.data != null) {
						var game=msg.data;
						console.log(msg.data);
						$("#numberA").attr("src","${pageContext.request.contextPath}/images/poke/"+game.numA+"_"+game.numberA+".JPG");
						$("#numberB").attr("src","${pageContext.request.contextPath}/images/poke/"+game.numB+"_"+game.numberB+".JPG");
						$("#numberC").attr("src","${pageContext.request.contextPath}/images/poke/"+game.numC+"_"+game.numberC+".JPG");
						$("#numberD").attr("src","${pageContext.request.contextPath}/images/poke/"+game.numD+"_"+game.numberD+".JPG");
						$("#msgBox").text("共有"+game.answerCount+"种解法");
					}
				} else {
					showMsg("加载错误！");
				}
			}
		});
	}

	
</script>
</html>
