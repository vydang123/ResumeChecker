<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

  <title>Appointment List Page</title>

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
	        	<h2 style="color: white;">Appointment List</h2>
	      	</div>
	
	      <c:if test="${not empty appointments}">
	        <div class="appointment_list">
	            <c:forEach var="appointment" items="${appointments}">
	                <div class="appointment_card">
	                    <p> Title: ${appointment.title} </p>

		                <c:set var="appointmentDate" value="${fn:substring(appointment.date, 0, 10)}" />

		                <c:set var="appointmentTime" value="${fn:substring(appointment.date, 11, 19)}" />
		
		                <p> Date: ${appointmentDate} </p>
		                <p> Time: ${appointmentTime} </p>
	                    <p> Job Seeker: ${appointment.jobSeekerID} </p>
	                    <p> Mentor: ${appointment.mentorID} </p>
	                    
	                    <c:set var="currentDate" value="<%= new java.text.SimpleDateFormat(\"yyyy-MM-dd\").format(new java.util.Date()) %>" />

	                    
	                    <c:choose>
		                    <c:when test="${appointment.date > currentDate}">
		                        <p class="status pending">Status: Pending <span></span></p>
		                        <div class="button-container">
			                        <button type="submit" class="btn btn-warning" name="action" id = "recheduleAppointment" value="RESCHEDULE">Reschedule</button>
			                        <form action="AppointmentServlet" method="post">
			                            <input type="hidden" name="appointmentId" value="${appointment.id}" />
	                                    <button type="submit" class="btn btn-danger" name="action" value="CANCEL">Cancel Appointment</button>
			                        </form>
								</div>
		                    </c:when>
		                    <c:otherwise>
		                        <p class="status done">Status: Done <span></span></p>
		                    </c:otherwise>
		                </c:choose>
		                
		                
	                </div>
	            </c:forEach>
	        </div>
	      </c:if>
	
	      <c:if test="${empty appointments}">
	        <p class="error_message">No appointment available.</p>
	      </c:if>
		</div>
	</div>
	
	<div id="myModal" class="modal">
	  <!-- Modal content -->
	  <div class="modal-content">
	    <h2>Reschedule Appointment</h2>
	    <form action="AppointmentServlet" method="post">
	      <input type="hidden" id="modalAppointmentId" name="appointmentId" />
	      
	      <div class="form-group">
		      <label for="newDate">Select New Date:</label>
		      <input type="date" id="newDate" name="newDate" required>
		  </div>
		  
		  <div class="form-group">
	      	<label for="newTime">Select New Time:</label>
	      	<input type="time" id="newTime" name="newTime" required>
		  </div>
	      <div class="button-container">
	        <button type="button" class="btn btn-secondary" id="closeModal">Cancel</button>
	        <button type="submit" class="btn btn-primary" name="action" value="UPDATE">Update</button>
	      </div>
	    </form>
	  </div>
	
	</div>
	  

    <!-- footer section -->
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- end  footer section -->


  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/custom.js"></script>
  <script>
  document.addEventListener("DOMContentLoaded", function() {
	    var modal = document.getElementById("myModal");
	    var rescheduleButtons = document.querySelectorAll("#recheduleAppointment");
	    var closeModalBtn = document.getElementById("closeModal");

	    rescheduleButtons.forEach(button => {
	        button.addEventListener("click", function() {
	            var appointmentId = this.closest(".appointment_card").querySelector("input[name='appointmentId']").value;
	            document.getElementById("modalAppointmentId").value = appointmentId;
	            modal.style.display = "block";
	        });
	    });

	    closeModalBtn.addEventListener("click", function() {
	        modal.style.display = "none";
	    });

	    window.addEventListener("click", function(event) {
	        if (event.target === modal) {
	            modal.style.display = "none";
	        }
	    });
	});
	</script>

</body>
</html>