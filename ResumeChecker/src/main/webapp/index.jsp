<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "v" %>
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

  <title>Home Page</title>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
  <div class="hero_area">
    <!-- header section strats -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- end header section -->
    <!-- slider section -->
    <section class="slider_section ">
      <div class="carousel_btn-container">
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="sr-only">Next</span>
        </a>
      </div>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active">01</li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1">02</li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2">03</li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container-fluid">
              <div class="row">
                <div class="col-md-5 offset-md-1">
                  <div class="detail-box">
                    <h1>
                      Find Your Perfect Mentor <br>
                      To Improve Your Resume
                    </h1>
                    <p>
                      Connect with professionals who can help enhance your resume and guide you towards your dream job.
                    
                    </p>
                    <div class="btn-box">
                      <a href="registerMentor.jsp" class="btn-1">
                        Become A Mentor
                      </a>
                      <a href="registerJobSeeker.jsp" class="btn-2">
                        Job Seeker Register
                      </a>
                    </div>
                  </div>
                </div>
                <div class="offset-md-1 col-md-4 img-container">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container-fluid">
              <div class="row">
                <div class="col-md-5 offset-md-1">
                  <div class="detail-box">
                    <h1>
                      Perfect Your Resume <br>
                      With Expert Feedback
                    </h1>
                    <p>
                     Job seekers can upload resumes and get feedback on how well their resumes match job descriptions.
                    </p> 
                  </div>
                </div>
                <div class="offset-md-1 col-md-4 img-container">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container-fluid">
              <div class="row">
                <div class="col-md-5 offset-md-1">
                  <div class="detail-box">
                    <h1>
                      Empower Job Seekers <br>
                      With Tailored Guidance
                    </h1>
                    <p>
                      As a mentor, you can provide personalized guidance to help job seekers enhance their resumes and secure their next opportunity.
                    </p>
                    <div class="btn-box">
                      <a href="registerMentor.jsp" class="btn-1">
                        Become A Mentor
                      </a>
                      <a href="registerJobSeeker.jsp" class="btn-2">
                        Job Seeker Register
                      </a>
                    </div>
                  </div>
                </div>
                <div class="offset-md-1 col-md-4 img-container">
                  <div class="img-box">
                    <img src="images/slider-img.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </section>
    <!-- end slider section -->
  </div>
  
  <section class="about_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-10 col-lg-9 mx-auto">
          <div class="img-box">
            <img src="images/about-img.jpg" alt="">
          </div>
        </div>
      </div>
      <div class="detail-box">
        <h2>
          About Our Resume Matching Platform
        </h2>
        <p>
          Our platform helps job seekers to enhance their resumes by matching them with job descriptions and mentors who can offer valuable feedback and guidance. Job seekers can also upload their resumes to see how closely they match the ideal job requirements.
        </p>
      </div>
    </div>
  </section>
  
   <section class="about_section layout_padding">
	    <h1 class="heading">Resume to Job Description Matcher</h1>
	    <form action="HomeServlet" method="post" enctype="multipart/form-data" class="form-container">
	        <label class="form-label">Upload Resume (PDF):</label>
	        <input type="file" name="resume" accept="application/pdf" required class="form-input"><br><br>
	        
	        <label class="form-label" for="jobDescription">Enter Job Description:</label><br>
	        <textarea name="jobDescription" rows="8" cols="50" required class="form-textarea"></textarea><br><br>
	        
	        <input type="submit" value="Check Match" class="form-button">
	    </form>
	</section>
	
	<section class="about_section layout_padding">
	    <h1 class="heading">Resume Matching Result</h1>
	    <p class="result-text"><strong>Match Percentage:</strong> <span id="matchPercentage">${matchPercentage}%</span></p>
	</section>
    <!-- experience section -->

  <!-- footer section -->
  <jsp:include page="footer.jsp"></jsp:include>
  <!-- end  footer section -->


  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/custom.js"></script>


</body>

</html>