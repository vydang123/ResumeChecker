<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "v" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <title>Login Page</title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>
<body class="sub_page">
	<div class="hero_area">
	<jsp:include page="header.jsp"></jsp:include>
	  <div class="container layout_padding">
	    <div class="row justify-content-center">
	      <div class="col-md-6">
	        <div class="card p-4">
	          <h2 class="text-center mb-4">Login</h2>
	          <form action="LoginServlet" method="post">
	          	<input type="text" name="action" value="LOG_IN" hidden>
	            <div class="form-group">
	              <label for="username">Username</label>
	              <input type="text" class="form-control" name="username" id="username" required>
	            </div>
	            <div class="form-group">
	              <label for="password">Password</label>
	              <input type="password" class="form-control" name="password" id="password" required>
	            </div>
	            
	            
	            <button type="submit" class="btn btn-primary btn-block">Login</button>
	            
	            
	          </form>
	         
	        </div>
	      </div>
	    </div>
	  </div>
	 </div>
  
    <!-- footer section -->
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- end  footer section -->


  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/custom.js"></script>
  
</body>
</html>