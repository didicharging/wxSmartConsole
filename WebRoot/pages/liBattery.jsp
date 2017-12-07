<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'liBattery.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME RESPONSIVE CSS -->
<link href="css/table-responsive.css" rel="stylesheet">
<!-- TABLE RESPONSIVE CSS -->
      <link rel="stylesheet" href="css/jquery.pagination.css" />


</head>

<body>

	<!-- BEGIN MAIN CONTENT -->

	<%@ include file="head.jsp"%>

	<%@ include file="left.jsp"%>

	<section id="main-content"> <!-- BEGIN WRAPPER  -->

    
	  <section class="wrapper">
		
 		<%@ include file="device/Libattery_48V.jsp"%> 




	 </section>
	<!-- END MAIN CONTENT -->

	<!-- BEGIN FOOTER -->

	<footer class="site-footer">
	<div class="text-center">
		2017 &copy; didiCharging by <a href="" target="_blank"> didi
			Enterprise </a> . <a href="http://www.mycodes.net" class="go-top"> <i
			class="fa fa-angle-up"> </i>
		</a>
	</div>
	</footer>
	<!-- END FOOTER -->

	</section>
	<!-- END SECTION -->


	<!-- BEGIN JS -->
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
	<!-- BASIC COMMON SCRIPT JS -->
	<script src="js/jquery.pagination.min.js"></script>
	
	<script src="myjs/device.js"></script>
	<!-- END JS -->
	

</body>
</html>
