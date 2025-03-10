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
		<div class="container layout_padding background-color" >
                <div class="profile_container">
                    <div class="profile_card">
                        <table class="profile_table">
                            <tr>
                                <th>First Name</th>
                                <td>${user.firstName}</td>
                            </tr>
                            <tr>
                                <th>Last Name</th>
                                <td>${user.lastName}</td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td>${user.email}</td>
                            </tr>
                            <tr>
                                <th>Date of Birth</th>
                                <td>${user.dob}</td>
                            </tr>

                            <!-- Additional details for occupation type 2 -->
                            <c:if test="${user.occupation == 2}">
                                <tr>
                                    <th>Description</th>
                                    <td>${user.description}</td>
                                </tr>
                                <tr>
                                    <th>Title</th>
                                    <td>${user.title}</td>
                                </tr>
                                <tr>
                                    <th>Price</th>
                                    <td>${user.price}</td>
                                </tr>
                            </c:if>
                        </table>
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