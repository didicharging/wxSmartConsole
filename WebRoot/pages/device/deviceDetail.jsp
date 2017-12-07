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


</head>

<body>

	<section id="container" class=""> <%@ include
		file="../head.jsp"%> <%@ include
		file="../left.jsp"%> <!-- BEGIN MAIN CONTENT -->
	<section id="main-content"> <!-- BEGIN WRAPPER  --> <section
		class="wrapper">
	<div class="mail-box">
		<aside class="sm-side"> <!-- INBOX HEADER -->
		<div class="user-head">
			<a href="javascript:;" class="inbox-avatar"> <img
				src="img/mail-avatar.jpg" alt="">
			</a>
			<div class="user-name">
				<h3>
					<a href="#">${device.deviceNo}</a>
				</h3>

			</div>
		</div>
		<!-- INBOX HEADER --> <!-- INBOX BODY -->
		<div class="inbox-body">

			<!-- INBOX NAV -->


			<ul class="nav nav-pills nav-stacked labels-info inbox-divider">
				<li>
					<h4>设备描述</h4>
				</li>

				<li><a><b>设备名称: </b> <i>${device.name}</i> </a></li>

				<li><a><b>设备描述 : </b> <i>${device.description}</i> </a></li>


				<li><a><b>注册时间 : </b> <i> <fmt:formatDate
								value="${device.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
					</i> </a></li>

				<li><a><b>最后扫码: </b> <i> <fmt:formatDate
								value="${device.updateTime }" pattern="yyyy-MM-dd HH:mm:ss" />
					</i> </a></li>

			</ul>


			<ul class="nav nav-pills nav-stacked labels-info inbox-divider">
				<li>
					<h4>用户</h4>
				</li>

				<li><a><b>所有人 : </b> <i>${device.owner_d.nickName}</i> </a></li>
				<li><a><b>充电侠 : </b> <i>${device.manager_d.nickName}</i> </a></li>
				<li><a><b>当前用户 : </b> <i>${device.user_d.nickName}</i> </a></li>

			</ul>

			<ul class="nav nav-pills nav-stacked labels-info ">
				<li>
					<h4>价格</h4>
				</li>

				<li><c:choose>

						<c:when test="${device.rentalType== '1'}">
							<a><b>租金 : </b> <i>${device.rentalH}/小时</i> </a>
						</c:when>

						<c:when test="${device.rentalType== '2'}">
							<a><b>租金 : </b> <i>${device.rentalM}嘀嘀币/天</i> </a>
						</c:when>


						<c:when test="${device.rentalType== '3'}">
							<a><b>租金 : </b> <i>${device.rental}/月</i> </a>
						</c:when>

						<c:otherwise>
							<a><b>租金 : </b> <i> 请输入</i> </a>
						</c:otherwise>

					</c:choose></li>

				<li><a><b>定价 : </b> <i>${device.price}元</i> </a></li>

				<li><a><b>换电价格 : </b> <i>${device.changeDdb}</i>嘀嘀币/次 </a></li>

				<li><a><b>充电价格 : </b> <i>${device.chargeDdb}</i>嘀嘀币/次 </a></li>

			</ul>


			<div class="inbox-body text-center">
				<div class="btn-group">
					<a href="javascript:;" class="btn mini btn-danger"> <i
						class="fa fa-power-off"></i>
					</a>
				</div>
				<div class="btn-group">
					<a href="javascript:;" class="btn mini btn-primary"> <i
						class="fa fa-cogs"></i>
					</a>
				</div>
			</div>
		</aside>

		<!-- INBOX MAIL CONTAINER -->

		<aside class="lg-side">
		<div class="inbox-head">
			<center>
				<h3>扫码记录</h3>
			</center>

		</div>


		<div class="inbox-body row pre-scrollable" style="max-height: 680px;">
			
			<table class="table table-striped table-hover table-bordered">

				<thead>
					<tr>

						<th class="hidden-phone">序号</th>
						<th class="hidden-phone">用户尼称</th>
						<th class="hidden-phone">领取时间</th>
						<th class="hidden-phone">归还时间</th>
						<th class="hidden-phone">操作</th>
					</tr>

				</thead>


				<tbody id="payShareContent">

					<c:forEach var="item" items="${ list}" varStatus="status">
						<tr class="">
							<td>${status.count}</td>
							<td class="hidden-phone">${item.user.nickName}</td>
							<td class="center hidden-phone"><fmt:formatDate
									value="${item.startDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td class="center hidden-phone"><fmt:formatDate
									value="${item.endDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>

							<td class="center hidden-phone">
							
							<c:choose>

									<c:when test="${item.opration== '1'}">
										<span class="label label-primary">租电</span>

									</c:when>

									<c:when test="${item.opration== '2'}">
										<span class="label  label-warning ">充电</span>
									</c:when>


									<c:when test="${item.opration== '6'}">
										<span class="label  label-Success ">换电</span>
									</c:when>

									<c:otherwise>
										<span class="label  label-default ">早期数据，无类型</span>
									</c:otherwise>

								</c:choose></td>

						</tr>
					</c:forEach>

				</tbody>

			</table>


		</div>
		</aside>

		<!-- INBOX MAIL CONTAINER -->
	</div>
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
	<!-- BASIC COMMON  JS -->
	<script src="myjs/deviceDetail.js"></script>


</body>
</html>
