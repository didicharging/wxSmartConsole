<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> didiAdmin </title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="css/bootstrap.min.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="css/bootstrap-reset.css" rel="stylesheet"><!-- BOOTSTRAP CSS -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"><!-- FONT AWESOME ICON CSS -->
	<link href="css/style.css" rel="stylesheet"><!-- THEME BASIC CSS -->
	<link href="css/style-responsive.css" rel="stylesheet"><!-- THEME RESPONSIVE CSS -->
	

  </head>
  
  <body class="login-screen">
    <!-- BEGIN SECTION -->
    <div class="container">
      <form class="form-signin" action="${pageContext.request.contextPath }/admin/login">
        <h2 class="form-signin-heading">
          	嘀嘀管理后台
        </h2>
		<!-- LOGIN WRAPPER  -->
        <div class="login-wrap">
          <input type="text" class="form-control" name="name" placeholder="User ID" autofocus>
          <input type="password" class="form-control" name="pwd" placeholder="Password">
          
          <label class="checkbox">
            <input type="checkbox" value="remember-me">
                                  记住我
            <span class="pull-right">
              <a data-toggle="modal" href="#myModal">
                              忘记密码
              </a>
            </span>
          </label>
           <p style="color: red;">
            ${errMessage}
          </p>
          <button class="btn btn-lg btn-login btn-block" type="submit">
           	 登录
          </button>
          
          
        </div>
		<!-- END LOGIN WRAPPER -->
				
		
		<!-- MODAL -->
        <div  id="myModal" class="modal fade">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                  &times;
                </button>
                <h4 class="modal-title">
                  Forgot Password ?
                </h4>
              </div>
              <div class="modal-body">
                <p>
                  Enter your e-mail address below to reset your password.
                </p>
               <!--  <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix"> -->
              </div>
              <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">
                  Cancel
                </button>
                <button class="btn btn-success" type="button">
                  Submit
                </button>
                
        
                
              </div>
              
            </div>
          </div>
        </div>
		<!-- END MODAL -->
      </form>
    </div>
    <!-- END SECTION -->
    
    
    <!-- BEGIN JS -->
    <script src="js/jquery.js" ></script><!-- BASIC JQUERY LIB. JS -->
	<script src="js/bootstrap.min.js" ></script><!-- BOOTSTRAP JS -->
    <!-- END JS -->
  </body>
</html>
