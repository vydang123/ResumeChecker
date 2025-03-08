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
	        	<h2 style="color: white;">Mentors List</h2>
	      	</div>
	
	      <c:if test="${not empty mentors}">
	        <div class="mentor_list">
	            <c:forEach var="mentor" items="${mentors}">
	                <div class="mentor_card">
	                    <div class="mentor_header" onclick="toggleMentor(this)">
	                        <span class="mentor_name">${mentor.firstName} ${mentor.lastName}</span>
	                        <span class="mentor_info">${mentor.email} - ${mentor.title} - $${mentor.price}</span>
	                    </div>
	                    <div class="mentor_details">
	                    	
	                        <p>${mentor.description}</p>
	                        
	                        <a href="BookingServlet?&mentorID=${mentor.id}" class="btn btn-primary">Make Appointment</a>
	                    </div>
	                </div>
	            </c:forEach>
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
  <script>
    function toggleMentor(element) {
        var details = element.nextElementSibling;
        details.style.display = (details.style.display === "block") ? "none" : "block";
    }
  </script>
</body>
</html>