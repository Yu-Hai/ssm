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
						<a role-type="playGame">玩游戏</a>
					</li>
					<li role="presentation" class="pointer">
						<a role-type="findAnswer">找答案</a>
					</li>
			</ul>
		</div>
		<!-- 玩游戏 -->
		<div id="playGame" class="col-sm-8 pull-left border-normal div-content">
			<div class="col-sm-12 border-normal div-msg">
				<img id="numberA" src="" width="135" height="200" />
				<img id="numberB" src="" width="135" height="200" />
				<img id="numberC" src="" width="135" height="200" />
				<img id="numberD" src="" width="135" height="200" />
				<input id="inputA" type="hidden" value=""/>
				<input id="inputB" type="hidden" value=""/>
				<input id="inputC" type="hidden" value=""/>
				<input id="inputD" type="hidden" value=""/>
			</div>
			<div class="clearfix"></div>
			<div id="msgBox"></div>
			
			<div id="solution" class="col-sm-12 border-normal div-solution" contenteditable="true"></div>
		</div>
		<!-- 找答案 -->
		<div id="findAnswer" class="col-sm-8 pull-left border-normal div-content hidden">
			<div class="col-sm-12 border-normal div-find-msg">
				<form id="findForm" class="form-inline">
						<input type="text" class="input-mini" id="inputNumA" placeholder="Input number A">
						<input type="text" class="input-mini" id="inputNumB" placeholder="Input number B">
						<input type="text" class="input-mini" id="inputNumC" placeholder="Input number C">
						<input type="text" class="input-mini" id="inputNumD" placeholder="Input number D">
						<button type="button" id="toFindAnswer" class="btn">Search</button>
				</form>
				<ul class="nav nav-pills nav-stacked" role="tablist" id="showAnswer">
					
				</ul>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		general24PointGame();
	});

	$("#solution").keyup(function() {
		if(event.keyCode == 13) {
			var solution=$("#solution").text();
			var numberA=$("#inputA").val();
			var numberB=$("#inputB").val();
			var numberC=$("#inputC").val();
			var numberD=$("#inputD").val();
			var data={"solution":solution,"numberA":numberA,"numberB":numberB,"numberC":numberC,"numberD":numberD};
			check24PointGameResult(data);
		}
	});
	
	$("#toFindAnswer").click(function(){
		var numberA=$("#inputNumA").val();
		var numberB=$("#inputNumB").val();
		var numberC=$("#inputNumC").val();
		var numberD=$("#inputNumD").val();
		var data={"numberA":numberA,"numberB":numberB,"numberC":numberC,"numberD":numberD};
		find24PointAnswer(data);
	});

	function find24PointAnswer(data) {
		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/game/find24PointAnswer.do",
					cache:false,
					dataType:"json",
					data : data,
					success : function(msg) {
						if (msg.responseCode == "0000") {
							var answerList=msg.data.answerList;
							$("#showAnswer").empty();
							var html="";
							for(var i=0;i<answerList.length;i++){
								html=html+"<li role=\'presentation\'>"+answerList[i]+"</li>";
							}
							$("#showAnswer").append(html);
						} else {
							showMsg("加载错误！");
						}
					}
				});
	}
	
	
	function check24PointGameResult(data) {
		$
				.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/game/check24PointGameResult.do",
					cache:false,
					dataType:"json",
					data : data,
					success : function(msg) {
						if (msg.responseCode == "0000") {
							showMsg(msg.data.msg);
							if(msg.data.success){
								general24PointGame();
							}
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
						$("#inputA").val(game.numberA);
						$("#inputB").val(game.numberB);
						$("#inputC").val(game.numberC);
						$("#inputD").val(game.numberD);
						$("#msgBox").text("共有"+game.answerCount+"种解法");
					}
				} else {
					showMsg("加载错误！");
				}
			}
		});
	}
	
	$("#leftNav ul li").click(function(){
		$(this).addClass("active");
		var $type=$(this).find("a").attr("role-type");
		$("#"+$type).removeClass("hidden").show();
		$(this).siblings().each(function() {
			$type=$(this).find("a").attr("role-type");
			$("#"+$type).hide();
			$(this).removeClass("active");
		});
	});

	
</script>
</html>
