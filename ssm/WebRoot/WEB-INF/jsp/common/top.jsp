<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common.jsp"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" >
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/user/index.do">Brand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<c:forEach items="${currentUser.permissions }" var="data" varStatus="sta">
					<c:if test="${data.type=='menu' }">
						<li class='${sta.index==0?"active":"" }'>
							<a href="${pageContext.request.contextPath}${data.url }.do">${data.permission }</a>
						</li>
					</c:if>
				</c:forEach>
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">${currentUser.username } <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	
	
	
	<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" 
   aria-labelledby="msgModalLabel" aria-hidden="true" style="z-index:1100">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h6 class="modal-title" id="msgModalLabel">
               提示信息
            </h6>
         </div>
         <div id="msg" class="modal-body">
            
         </div>
         <div class="modal-footer">
            <button type="button" class="btn btn-primary btn-xs" 
               data-dismiss="modal">关闭
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>

<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" 
   aria-labelledby="confirmModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h6 class="modal-title" id="confirmModalLabel">
            </h6>
         </div>
         <div id="msg" class="modal-body">
            确定操作？
         </div>
         <div class="modal-footer">
         	<button type="button" class="btn btn-primary btn-xs" 
               data-dismiss="modal">关闭
            </button>
            
            <button type="button" class="btn btn-primary btn-xs" onclick="doIt()" data-dismiss="modal">
               	确定
            </button>
         </div>
      </div><!-- /.modal-content -->
</div><!-- /.modal -->
</div>
