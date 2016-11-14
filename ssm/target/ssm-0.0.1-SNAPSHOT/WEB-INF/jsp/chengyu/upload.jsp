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

<title>My JSP 'upload.jsp' starting page</title>

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
	<input type="button" value="添加附件" onclick="createInput('more');" />
	<div id="more"></div>
</body>
<script type="text/javascript">
	var count = 1;
	/** 
	 * 生成多附件上传框 
	 */
	function createInput(parentId) {
		count++;
		var str = '<div name="div" ><font style="font-size:12px;">附件</font>'
				+ '   '
				+ '<input type="file" contentEditable="false" id="uploads' + count + '' +  
    '" name="uploads'+ count +'" value="" style="width: 220px"/><input type="button"  value="删除" onclick="removeInput(event)" />'
				+ '</div>';
		document.getElementById(parentId).insertAdjacentHTML("beforeEnd", str);
	}
	/** 
	 * 删除多附件删除框 
	 */
	function removeInput(evt, parentId) {
		var el = evt.target == null ? evt.srcElement : evt.target;
		var div = el.parentNode;
		var cont = document.getElementById(parentId);
		if (cont.removeChild(div) == null) {
			return false;
		}
		return true;
	}

	function addOldFile(data){  
	    var str = '<div name="div' + data.name + '" ><a href="#" style="text-decoration:none;font-size:12px;color:red;" onclick="removeOldFile(event,' + data.id + ')">删除</a>'+  
	    '   ' + data.name +   
	    '</div>';  
	    document.getElementById('oldImg').innerHTML += str;  
	}  

	function removeOldFile(evt, id) {
		//前端隐藏域，用来确定哪些file被删除，这里需要前端有个隐藏域  
		$("#imgIds")
				.val(
						$("#imgIds").val() == "" ? id : ($("#imgIds").val()
								+ "," + id));
		var el = evt.target == null ? evt.srcElement : evt.target;
		var div = el.parentNode;
		var cont = document.getElementById('oldImg');
		if (cont.removeChild(div) == null) {
			return false;
		}
		return true;
	}

	function ajaxFileUploadImg(id) {
		//获取file的全部id  
		var uplist = $("input[name^=uploads]");
		var arrId = [];
		for (var i = 0; i < uplist.length; i++) {
			if (uplist[i].value) {
				arrId[i] = uplist[i].id;
			}
		}
		$.ajaxFileUpload({
			url : 'xxxxx',
			secureuri : false,
			fileElementId : arrId, //这里不在是以前的id了，要写成数组的形式哦！  
			dataType : 'json',
			data : {
			//需要传输的数据  
			},
			success : function(data) {
			},
			error : function(data) {
			}
		});
	}
</script>
</html>
