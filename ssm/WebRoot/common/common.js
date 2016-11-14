function showMsgDiv(msgStr){
	 $("#msgDiv").show();
	$("#msg").html(msgStr);
}
function showMsg(msgStr){
	$('#msgModal').modal("show");
	$("#msg").html(msgStr);
}
var _callback;
var _param;
function showConfirm(callback,param){
	$('#confirmModal').modal("show");
	_callback = callback;
	_param = param;
}
function doIt(){
	_callback(_param);
}