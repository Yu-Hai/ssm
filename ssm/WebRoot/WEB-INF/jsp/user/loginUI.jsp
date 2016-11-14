<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
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

<title>My JSP 'loginUI.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="col-sm-4">
		<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/user/login.do" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="username"
						id="userName" placeholder="UserName">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password"
						id="password" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label id="msgBox"> </label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox" name="rememberMe"> Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="toSubmit" type="button" class="btn btn-default">Sign in</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">

$("#toSubmit").click(function(){
	var data=$(".form-horizontal").serialize();
	$.ajax({
		type : "POST",
		url : "${pageContext.request.contextPath}/user/login.do",
		data : data,
		async : false,
		success : function(msg) {
			if (msg.responseCode == "0000") {
				if(msg.data.success){
					location.href = "${pageContext.request.contextPath}/user/toIndex.do";
				}else{
					$("#msgBox").text(msg.data.msg);
				}
			} else {
				showMsg("服务器内部发生错误！");
			}
		}
	});
	
	
});
</script>
</html>
