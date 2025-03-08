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

  <title>Profile Page</title>

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

            <c:if test="${not empty sessionScope.user}">
                <c:set var="user" value="${sessionScope.user}" />
                <div class="profile_container">
                    <div class="profile_card">
                       <h3>Welcome, ${sessionScope.user.firstName} ${sessionScope.user.lastName}!</h3>

						<form action="ProfileServlet" method="POST">
			              <table class="profile_table">
			                <tr>
			                  <th>First Name</th>
			                  <td><input type="text" name="firstName" value="${sessionScope.user.firstName}" /></td>
			                </tr>
			                <tr>
			                  <th>Last Name</th>
			                  <td><input type="text" name="lastName" value="${sessionScope.user.lastName}" /></td>
			                </tr>
			                <tr>
			                  <th>Email</th>
			                  <td><input type="email" name="email" value="${sessionScope.user.email}" /></td>
			                </tr>
			                <tr>
			                  <th>Date of Birth</th>
			                  <td><input type="date" name="dob" value="${sessionScope.user.dob}" /></td>
			                </tr>
			
			                <!-- Optional fields for occupation type 2 -->
			                <c:if test="${sessionScope.user.occupation == 2}">
			                  <tr>
			                    <th>Description</th>
			                    <td><textarea placeholder = "Introduce yourself to attract Job Seekers and provide availability" row = "6" type="text" name="description" > ${sessionScope.user.description}</textarea></td>
			                  </tr>
			                  <tr>
			                    <th>Title</th>
			                    <td><input type="text" name="title" value="${sessionScope.user.title}" /></td>
			                  </tr>
			                  <tr>
			                    <th>Price</th>
			                    <td><input type="number" name="price" value="${sessionScope.user.price}" /></td>
			                  </tr>
			                </c:if>
			              </table>
			              <button type="submit" class="btn btn-primary">Save Changes</button>
			            </form>
                    </div>
                </div>
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