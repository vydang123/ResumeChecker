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

  <title>Appointment Page</title>

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
		<div class="container layout_padding" >
			<div class= "form-container">
				<form action="BookingServlet?action=BOOK_APPOINTMENT&mentorID=${mentor.id}" method="post">
                   <div class="form-group">
	                   <label>Job Seeker:</label>
	                   <c:if test="${not empty sessionScope.user}">
	                   	<c:set var="user" value="${sessionScope.user}" />
	                   		<input type="text" name="jsName" value="${sessionScope.user.firstName} ${sessionScope.user.lastName}" readonly >
	                   </c:if>
	               </div>
	               <div class="form-group">
	                   <label>Price:</label>
	                   <input type="text" name="price" value="${mentor.price}" disabled>
					</div>
                   <div class="form-group">
                       <label>Mentor:</label>
                       <input type="text" name = "mentorName" class="form-control" value="${mentor.firstName} ${mentor.lastName}" disabled>
                   </div>
                   <div class="form-group">
                       <label>Title:</label>
                       <input type="text" class="form-control" name="title" required>
                   </div>
                   <div class="form-group">
                       <label>Date & Time:</label>
                       <input type="datetime-local" class="form-control" name="date" required>
                   </div>
                   <button type="submit" class="btn btn-primary">Submit</button>
               </form>
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