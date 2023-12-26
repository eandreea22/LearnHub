<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile</title>
		
		<link href="navMenu.css" rel="stylesheet" />
		
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
		
		 <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
		
        <link href="admin_mainPage.css" rel="stylesheet" />
         <link href="admin_users.css" rel="stylesheet" />
	
	</head>
	
	
		<nav class="menu" style="--hue: 294.39334849447846">
		  <input class="menu__toggle" id="menu-toggle" type="checkbox"/>
		  <label class="menu__toggle-label" for="menu-toggle"></label>
		  <label class="menu__toggle-label menu__toggle-label--closer" for="menu-toggle">
		    <svg class="menu__icon" preserveAspectRatio="xMinYMin" viewBox="0 0 24 24">
		      <path d="M3,6H21V8H3V6M3,11H21V13H3V11M3,16H21V18H3V16Z"></path>
		    </svg>
		    <svg class="menu__icon" preserveAspectRatio="xMinYMin" viewBox="0 0 24 24">
		      <path d="M19,6.41L17.59,5L12,10.59L6.41,5L5,6.41L10.59,12L5,17.59L6.41,19L12,13.41L17.59,19L19,17.59L13.41,12L19,6.41Z"></path>
		    </svg>
		  </label>
		  <ul class="menu__content">
		    <li class="menu__item" style="--x: 34; --y: 19; "><a class="menu__link" href="teacher_profile.jsp">Profile</a></li>
		    <li class="menu__item" style="--x: 63; --y: 37;"><a class="menu__link" href="teacher_support.jsp">Support</a></li>
		    <li class="menu__item" style="--x: 19; --y: 48;"><a class="menu__link" href="teacher_mainPage.jsp">Home</a></li>
		    <li class="menu__item" id="openModal" style="--x: 66; --y: 57;"><a class="menu__link" href="login.jsp">Logout</a></li>
		  </ul>
		  
		  
		</nav>
	
	
	
	
	<svg style="position: absolute; left: 100%">
	  <defs>
	    <filter id="goo">
	      <feGaussianBlur in="SourceGraphic" stdDeviation="15" result="BLUR"></feGaussianBlur>
	      <feColorMatrix in="BLUR" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="GOO"></feColorMatrix>
	      <feBlend in="SourceGraphic" in2="goo"></feBlend>
	    </filter>
	  </defs>
	</svg>
	
	<body>
	
	
		<header class="bg-dark py-5">
	            <div class="container px-5">
	                <div class="row gx-5 justify-content-center">
	                    <div class="col-lg-6">
	                        <div class="text-center my-5">
	                            <h1 class="display-5 fw-bolder text-white mb-2">Lorem ipsum dolor sit amet</h1>
	                            <p class="lead mb-4" style="color:white;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Invidiosum nomen est, infame, suspectum. Sed mehercule pergrata mihi oratio tua. Quae similitudo in genere etiam humano apparet.</p>
	                            
	                        </div>
	                    </div>
	                </div>
	            </div>
        </header>
        
        
        <!-- ------------------------------------------- -->
        
        
        
       <div class="field padding-bottom--24">
       	
       		
       			<p style="font-size:30px;">My Profile</p>
       		
       		
        	 
        	 
        	 <div class="prof" style=" margin: auto;
									  width: 600px;
									  border: 3px solid #E8EBF0;
									  padding: 10px;">
        	 
	        	 <form action="TeacherProfile" method="get">
	        	 	<p style="text-align:left; margin-left: 10px; font-size: 20px;"><%= (request.getAttribute("email") != null) ? request.getAttribute("email") : "Email:" %></p>
	        	 	<p style="text-align:left; margin-left: 10px; font-size: 20px;"><%= (request.getAttribute("name") != null) ? request.getAttribute("name") : "Name:" %></p>
	        	 	<p style="text-align:left; margin-left: 10px; font-size: 20px;"><%= (request.getAttribute("university") != null) ? request.getAttribute("university") : "University:" %></p>
	        	 	<p style="text-align:left; margin-left: 10px; font-size: 20px;"><%= (request.getAttribute("degree") != null) ? request.getAttribute("degree") : "Degree:" %></p>
	        	 	
	        	 	<hr>
	        	 	<p style="text-align:left; margin-left: 10px; font-size: 20px;">Change your password</p>
	        	 	
	        	 	<p style="text-align:left; margin-left: 60px; font-size: 20px;">Password:</p>
	        	 	<input type="text" name="password" id="password" placeholder="old password" style="width: 50%; margin-left: -170px;">
	        	 	<br>
	        	 	
	        	 	<p style="text-align:left; margin-left: 60px; font-size: 20px; margin-top:20px;">New Password:</p>
	        	 	<input type="text" name="newpassword" id="newpassword" placeholder="new password" style="width: 50%; margin-left: -170px;">
	        	 	
	        	 	<p style="text-align:left; margin-left: 60px; font-size: 14px;"><%= (request.getAttribute("mesaj") != null) ? request.getAttribute("mesaj") : "" %></p>
	        	 	
	        	 	<div class="field padding-bottom--24" style="margin-left: -280px;">
		                  <input type="submit" name="submit" value="Update password">
		            </div>
	        	 	
	        	 </form>
        	 
        	 </div>
        	 
        	 <!-- pt paragraf -->
        	 <!--  -->
        	<br><br>
	        
        	
        </div>
      	
      	
        
	
	</body>

 <!-- ------------------------------------------- -->
	<footer class="relative bg-blueGray-200 pt-8 pb-6">
	  <div class="container mx-auto px-4">
	    <div class="flex flex-wrap text-left lg:text-left">
	      <div class="w-full lg:w-6/12 px-4">
	        <h4 class="text-3xl fonat-semibold text-blueGray-700" style="color:white;">Let's learn together!</h4>
	        <h5 class="text-lg mt-0 mb-2 text-blueGray-600" style="color:white;">
	          Use our platform and everything is going to be great!
	        </h5>
	        
	      </div>
	      <div class="w-full lg:w-6/12 px-4">
	        <div class="flex flex-wrap items-top mb-6">
	          <div class="w-full lg:w-4/12 px-4 ml-auto">
	            <span class="block uppercase text-blueGray-500 text-sm font-semibold mb-2" style="color:white;">Useful Links</span>
	            <ul class="list-unstyled">
	              <li>
	                <a class="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm" href="gc.jsp" style="color:white;">General conditions</a>
	              </li>
	              <li>
	                <a class="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm" href="tc.jsp" style="color:white;">Terms and conditions</a>
	              </li>
	            </ul>
	          </div>
	        </div>
	      </div>
	    </div>
	    <hr class="my-6 border-blueGray-300">
	    
	  </div>
	  
	</footer>
</html>