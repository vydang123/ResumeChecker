<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

  <title>Mentor List Page</title>

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
			<div class="heading_container text-center">
	        <h2>Mentors List</h2>
	      </div>
	
	      <c:if test="${not empty mentors}">
	        <div class="profile_container">
	          <div class="profile_card">
	            <table class="profile_table">
	              <thead>
	                <tr>
	                  <th>First Name</th>
	                  <th>Last Name</th>
	                  <th>Email</th>
	                  <th>Title</th>
	                  <th>Price</th>
	                </tr>
	              </thead>
	              <tbody>
	                <c:forEach var="mentor" items="${mentors}">
	                  <tr>
	                    <td>${mentor.firstName}</td>
	                    <td>${mentor.lastName}</td>
	                    <td>${mentor.email}</td>
	                    <td>${mentor.title}</td>
	                    <td>${mentor.price}</td>
	                  </tr>
	                </c:forEach>
	              </tbody>
	            </table>
	          </div>
	        </div>
	      </c:if>
	
	      <c:if test="${empty mentors}">
	        <p class="error_message">No mentors available.</p>
	      </c:if>
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