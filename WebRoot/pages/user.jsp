<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<link rel="shortcut icon" href="img/favicon.ico">

<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!-- BOOTSTRAP CSS -->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- FONT AWESOME ICON STYLESHEET -->
<link rel="stylesheet" href="assets/data-tables/DT_bootstrap.css">
<!-- DATATABLE CSS -->
<link href="css/style.css" rel="stylesheet">
<!-- THEME BASIC CSS -->
<link href="css/style-responsive.css" rel="stylesheet">
<!-- THEME BASIC RESPONSIVE  CSS -->
<link rel="stylesheet" href="css/jquery.pagination.css" />

<title>交共享金</title>

</head>

<body>
	<!-- BEGIN SECTION -->
	<section id="container" class=""> <%@ include file="head.jsp"%>
	<%@ include file="left.jsp"%>

		 <!-- BEGIN MAIN CONTENT --> 
         <section id="main-content">
		    <!-- BEGIN WRAPPER  -->
            <section class="wrapper site-min-height">
               <section class="panel">
                  <header class="panel-heading">
                     <span class="label label-primary ">用户列表</span> 
                     
                  </header>
                  <div class="panel-body">
                     <div class="adv-table editable-table ">
                        <div class="clearfix">
                                   
                           	<form class="form-inline" role="form" id="searchForm" method="post">

									<div class="form-group">
									
										<label class="control-label">起始日期</label>
										 <input type="text"
											class="form-control datepicker" id="startTime" name="startTime"
											 data-date-format="yyyy-mm-dd">
                                     
									</div>
				
									
									<div class="form-group">
										<label class="control-label">结束日期</label> <input type="text"
											class="form-control datepicker" id="endTime" name="endTime"
											data-date-format="yyyy-mm-dd">
									</div>

									<div class="form-group">
										<label class="control-label">电话</label> 
										<input type="text"
											class="form-control" id="phone" name="phone">
									</div>

									<div class="form-group">
										<label class="control-label">姓名</label> 
										<input type="text"
											class="form-control" id="name" name="name" value="${name}">
									</div>									

									<div class="form-group">
										<label class="control-label">尼称</label> 
										<input type="text"
											class="form-control" id="nickName" name="nickName">
									</div>	

							</form> 
                              
                        </div>
							 <button onclick="loadListData(1);" class="btn btn-primary">
                                                                                开始查看
                              </button>
                        
                    
                        <div class="space15">&nbsp</div>
                        
       																						
                        <table class="table table-striped table-hover table-bordered" id="sample" >
                     
                           <thead>
                              <tr>
                                 <th class="hidden-phone"  >序号</th>
                                 <th class="hidden-phone" >头像</th>
                                 <th class="hidden-phone" >姓名</th>
                                 <th class="hidden-phone" >尼称</th>
                                 <th class="hidden-phone" >嘀嘀币</th>
                                 <th class="hidden-phone" >押金</th>
                                
                                 <th class=" hidden-phone" >注册时间</th>
                                 <th class=" hidden-phone" >状态</th>
                                 <th class=" hidden-phone" >操作</th>
                                 </tr>
                           </thead>
                      
                           
                           <tbody id="userContent">
                           
               
                           </tbody>
                        </table>
                      
                        <center>
							  <div id="list_page_info"></div>
						</center>
                        
                        
                     </div>
                  </div>
               </section>
            </section>
			<!-- END WRAPPER  -->
         </section>
		 <!-- END MAIN CONTENT --> 


      <!-- BEGIN JS --> 	  
		<script src="js/jquery-1.8.3.min.js" ></script><!-- BASIC JS LIABRARY 1.8.3 -->
		<script src="js/bootstrap.min.js" ></script><!-- BOOTSTRAP JS  -->
		<script src="js/jquery.dcjqaccordion.2.7.js"></script><!-- ACCORDING JS -->
		<script src="js/jquery.scrollTo.min.js" ></script><!-- SCROLLTO JS  -->
		<script src="js/jquery.nicescroll.js" > </script><!-- NICESCROLL JS  -->
		<script src="assets/data-tables/jquery.dataTables.js"></script><!-- DATATABLE JS  -->
		<script src="assets/data-tables/DT_bootstrap.js"></script><!-- DATATABLE JS  -->
		<script src="js/respond.min.js" ></script><!-- RESPOND JS  -->
		<script src="js/common-scripts.js" ></script><!-- BASIC COMMON JS  -->
	 	<script src="js/editable-table.js" ></script> <!-- EDITABLE TABLE JS  -->            
        <script src="assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
       	<script src="js/jquery.pagination.min.js"></script>
       
        <script src="myjs/myUtil.js"></script>
        <script src="myjs/user.js"></script> 
   
	  <!-- END JS --> 
	  
   

</body>
</html>
