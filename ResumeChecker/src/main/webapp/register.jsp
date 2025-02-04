<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

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

  <title>Register Page</title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>
<body  class="sub_page">
	<div class="hero_area">
		<jsp:include page="headerGeneral.jsp"></jsp:include>
		<div class="container layout_padding">
		  <h2 class="text-center-register">Are you a:</h2>
	      <div class="register-buttons">
	        <a href="registerJobSeeker.jsp" class="register-button">
	          <img src="images/job-seeker.jpg" alt="Job Seeker">
	          Job Seeker
	        </a>
	        <a href="registerMentor.jsp" class="register-button">
	          <img src="images/mentor.jpg" alt="Mentor">
	          Mentor
	        </a>
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