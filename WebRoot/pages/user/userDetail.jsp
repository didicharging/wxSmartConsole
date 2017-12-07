<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'deviceDetail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<title>设备详情</title>
<!-- BEGIN STYLESHEET-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON CSS -->
<link href="assets/jquery-file-upload/css/jquery.fileupload-ui.css"
	rel="stylesheet" type="text/css">
<!-- FILE UPLOAD UI CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME RESPONSIVE CSS -->
<link href="css/device.css" rel="stylesheet">
<link href="assets/advanced-datatable/media/css/demo_page.css"
	rel="stylesheet">
<!-- ADVANCED DATATABLE CSS -->
<link href="assets/advanced-datatable/media/css/demo_table.css"
	rel="stylesheet">
<!-- ADVANCED DATATABLE CSS -->
<link rel="stylesheet" href="assets/data-tables/DT_bootstrap.css">

<link rel="stylesheet" type="text/css" href="assets/bootstrap-datepicker/css/datepicker.css"><!-- BOOTSTRAP DATEPICKER PLUGIN CSS -->
<link rel="stylesheet" type="text/css" href="assets/bootstrap-timepicker/compiled/timepicker.css"><!-- BOOTSTRAP TIMEPICKER PLUGIN CSS -->

<!-- DATATABLE CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME BASIC RESPONSIVE  CSS -->
<link rel="stylesheet" href="css/jquery.pagination.css" />

</head>

<body>

	<section id="container" class=""> <%@ include
		file="../head.jsp"%> <%@ include
		file="../left.jsp"%> <!-- BEGIN MAIN CONTENT -->
		
		
	<section id="main-content"> <!-- BEGIN WRAPPER  --> <section
		class="wrapper">
	<div class="mail-box" >
	
		<aside class="sm-side"> <!-- INBOX HEADER -->
		<div class="user-head">
			<a href="javascript:;" class="inbox-avatar"> <img
				src="${user.profileImage}" width="64px" height="64px" alt="">

			</a>
			<div class="user-name">
				<h4>
					<a href="#">${user.nickName}</a>
				</h4>
				<span> <a href="#">${user.name}</a>
				</span>

			</div>


		</div>
		
		
		<!-- INBOX HEADER --> <!-- INBOX BODY -->
			
		<div class="inbox-body" >

			<!-- INBOX NAV -->


			<ul class="nav nav-pills nav-stacked labels-info inbox-divider">
				<li>
					<h4>个人信息</h4>
				</li>

				<li><a><b>id : </b> <i>${user.id}</i> </a></li>
				<li><a><b>微信号 : </b> <i>${user.wechatId}</i> </a></li>
				<li><a><b>电话 : </b> <i>${user.phone}</i> </a></li>
				<li><a><b>身份证号 : </b> <i>${user.idCard}</i> </a></li>

				<li><a hr nef="${user.photo}"><b>照片 : </b> <%--    <img src="${user.profileImage}" width="120px" height="120px" alt="">	 --%>
						<img src="${user.photo}" width="120px" height="120px" alt="">

				</a></li>

				<li><a><b>注册时间 : </b> <i> <fmt:formatDate
								value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
					</i> </a></li>

			</ul>


			<ul class="nav nav-pills nav-stacked labels-info inbox-divider">
				<li>
					<h4>帐户</h4>
				</li>

				<li><a><b>嘀嘀币 : </b> <i>${wallet.amount}</i> </a></li>
				<li><a><b>押金 : </b> <i>${wallet.shareAmount}</i> </a></li>
				<li><a><b>状态 : </b> <c:choose>

					<%-- 		<c:when test="${user.state== '0'}">
								<span class="label label-primary">未认证</span>

							</c:when>

							<c:when test="${user.state== '1'}">
								<span class="label  label-warning ">已认证</span>
							</c:when> --%>

							<c:when test="${wallet.role== '99'}">
								<span class="label  label-Success ">充电侠</span>
							</c:when>

							<c:when test="${wallet.role== '98'}">
								<span class="label  label-Success ">集团用户</span>
							</c:when>							
							

							<c:otherwise>
								<span class="label  label-default ">普通用户</span>
							</c:otherwise>

						</c:choose> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						
						<button  class="btn btn-info " onclick="canrecive('${user.id}')">认证通过</button> 
						<button  class="btn btn-info " onclick="notcanrecive('${user.id}')">取消认证</button> 
						</a>
						</li>
						
			
			
			
						
			</ul>
	

			<div class="inbox-body text-center">
				<div class="btn-group">
					<a href="javascript:;" class="btn mini btn-danger"> <i
						class="fa fa-power-off"></i>
					</a>
				</div>
				<div class="btn-group">
					<button class="btn mini btn-primary" onclick="getValiCode()"><i
						class="fa fa-cogs"></i></button>
				</div>
				    <div class="btn-group">
					<button class="btn mini btn-primary" data-toggle="modal" data-target="#addOrderModal">手动添加订单</button>
				</div>
												
			</div>
		</aside>

		<!-- INBOX MAIL CONTAINER -->

		<aside class="lg-side ">
		<div class="inbox-head">
			<center>
				<h3>日志详情</h3>
			</center>
		</div>
		<br />

		<%@ include file="walletLog.jsp"%> <%@ include
			file="deviceLog.jsp"%> <%@ include
			file="orders.jsp"%> <%@ include
			file="ddbLog.jsp"%> 
		
		</aside>
	
	</div>

		<%@ include file="userSet.jsp"%>  
 	<%@ include file="addOrder.jsp"%>  
	</section> <!-- END WRAPPER  --> </section> <footer class="site-footer">
	<div class="text-center">
		2013 &copy; Olive Admin by <a href="" target="_blank">Custom Theme</a>.
		<a href="http://www.mycodes.net" class="go-top"> <i
			class="fa fa-angle-up"></i>
		</a>
	</div>
	</footer> </section>

	<script src="js/jquery.js"></script>
	<!-- BASIC JQUERY LIB. JS -->
	<script src="js/bootstrap.min.js"></script>
	<!-- BOOTSTRAP JS -->
	<script src="js/jquery.dcjqaccordion.2.7.js"></script>
	<!-- ACCORDIN JS -->
	<script src="js/jquery.scrollTo.min.js"></script>
	<!-- SCROLLTO JS -->
	<script src="js/jquery.nicescroll.js"></script>
	<!-- NICESACROLL JS -->
	<script src="js/respond.min.js"></script>
	<!-- RESPOND JS -->

	<script src="js/common-scripts.js"></script>

	<script language="javascript"
		src="assets/advanced-datatable/media/js/jquery.dataTables.js"></script>
		
    <script src="assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>

	<script src="assets/data-tables/DT_bootstrap.js"></script>

    <script src="myjs/userDetail.js"></script> 

</body>
</html>
