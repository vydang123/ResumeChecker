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
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container layout_padding">
		    <div class="row justify-content-center">
		      <div class="col-md-8">
		        <div class="card p-4">
		          <h2 class="text-center mb-4">Mentor Register</h2>
		          <form action="RegisterServlet" method = "post" >	
		          	<div class="form-row">
		              <div class="form-group col-md-6">
		                <label for="firstname">First Name <span style="color: red;">*</span>(required)</label>
		                <input type="text" class="form-control" name="firstname" id="firstname" required>
		              </div>
		              <div class="form-group col-md-6">
		                <label for="lastname">Last Name <span style="color: red;">*</span>(required)</label>
		                <input type="text" class="form-control" name="lastname" id="lastname" required>
		              </div>
		            </div>	            
		              <div class="form-group">
		                <label for="username">Username <span style="color: red;">*</span>(required)</label>
		                <input type="text" class="form-control" name="username" id="username" required>
		              </div>
		              <div class="form-row">
			              <div class="form-group col-md-6">
			                <label for="password">Password <span style="color: red;">*</span>(required)</label>
			                <input type="password" class="form-control" name="password" id="password" required>
			                <!-- Password Strength Checklist -->
			                <ul>
			                  <li id="length">At least 8 characters <span></span></li>
			                  <li id="uppercase">At least 1 uppercase <span></span></li>
			                  <li id="lowercase">At least 1 lowercase <span></span></li>
			                  <li id="number">At least 1 number <span></span></li>
			                  <li id="special">At least 1 special character <span></span></li>
			                </ul>
			              </div>
			            <div class="form-group col-md-6">
			              <label for="email">Email <span style="color: red;">*</span>(required)</label>
			              <input type="email" class="form-control" name="email" id="email" required>
			            </div>
			           </div>
		            <div class="form-group">
		              <label for="dob">Date of Birth <span style="color: red;">*</span> (required)</label>
		              <input type="date" class="form-control" name="dob" id="dob" required>
		            </div>
		            <div class="form-row">
		              <div class="form-group col-md-6">
		                <label for="title">Title</label>
		                <input placeholder = "Your occupations" type="text" class="form-control" name="title" id="title">
		              </div>
		              <div class="form-group col-md-6">
		                <label for="price">Price</label>
		                <input type="number" class="form-control" name="price" id="price">
		              </div>
		            </div>
		            <div class="form-group">
		              <label for="description">Description</label>
		              <textarea placeholder = "Introduce yourself to attract Job Seekers and provide availability" class="form-control" name="description" id="description" rows="6"></textarea>
		            </div>
		            <input type="hidden" name="occupationId" value="2">     
		               
		            <button type="submit" class="btn btn-success btn-block">Register</button>	            
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