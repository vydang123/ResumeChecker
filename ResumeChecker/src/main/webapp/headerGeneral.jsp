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
	
	        </nav>
	      </div>
	 </header>
</body>
</html>