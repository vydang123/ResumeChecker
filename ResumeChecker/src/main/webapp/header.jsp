<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="header_section">
		<div class="container-fluid">
	        <nav class="navbar navbar-expand-lg custom_nav-container">
	          <a class="navbar-brand" href="index.jsp">
	            <img src="images/logo.png" alt="" />
	            <span>
	              Resume Checker
	            </span>
	          </a>
	          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	            <span class="navbar-toggler-icon"></span>
	          </button>
	
				<c:if test="${not empty sessionScope.user}">
			    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
			    		<p style="color: white; font-weight: bold;">Hello, ${sessionScope.user.firstName}</p>
			            <ul class="navbar-nav  ">
			              <li class="nav-item active">
			                <a class="nav-link" href="profile.jsp">Profile <span class="sr-only">(current)</span></a>
			              </li>
			              <li class="nav-item">
			                <a class="nav-link" href="MentorServlet"> Mentors</a>
			              </li>
			              <li class="nav-item">
			                <a class="nav-link" href="AppointmentServlet">Appointments </a>
			              </li>
			            </ul>
			        	<a href="LoginServlet?action=LOG_OUT&logout=true">Logout</a>
			        </div>
			        <div>
			            <div class="custom_menu-btn ">
			              <button>
			                <span class=" s-1">
			
			                </span>
			                <span class="s-2">
			
			                </span>
			                <span class="s-3">
			
			                </span>
			              </button>
			            </div>
			          </div>
			    </c:if>
			
			    <c:if test="${empty sessionScope.user}">
			        <div class="user_option">
		              <a href="login.jsp">
		                <span>
		                  Login
		                </span>
		              </a>
		              <span id = "space">/</span>
		              <a href="register.jsp">
		                <span>
		                  Register
		                </span>
		              </a>
		            </div>
			    </c:if>
	        </nav>
	      </div>
	 </header>
</body>
</html>