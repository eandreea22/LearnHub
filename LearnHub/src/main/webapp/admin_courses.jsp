<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Courses - Admin</title>
		
		<link rel="stylesheet" type="text/css" href="navMenu.css">
		
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
		
		 <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
		
        <link href="admin_mainPage.css" rel="stylesheet" />
        <link href="admin_users.css" rel="stylesheet" />
	
	</head>
	
	
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
        <section class="py-5 " id="features" style="height:auto;">
            <div style ="overflow:hidden;
					    overflow-y: scroll;
					    height: 500px; ">
				
					    				
				 <%
				    String htmlTable = (String) request.getAttribute("htmlTable");
				
				    out.println(htmlTable);
				%>
            </div>
            
            
        </section>
        <form action="AdminCourses" method="get">
        	<div class="field padding-bottom--24">
	        	<input type="submit" name="submit" value="Load Courses">
	        </div>
    
        </form>
        <hr>
        
        <div class="field padding-bottom--24">
        
	        <form action="AdminCourses" method="get">
	        
		        <p style="font-size:20px;"> Delete course</p>
	        	<input type="number" name="id" id="id" placeholder="id">
	        	<p><%= (request.getAttribute("mesaj1") != null) ? request.getAttribute("mesaj1") : "" %></p>
	            <div class="field padding-bottom--24">
	                  <input type="submit" name="submit" value="Delete">
	            </div>
	             
	             <hr> 
	             
	             <p style="font-size:20px;">Add course </p>
	             <input class="l1" type="text" name="name" id="name" placeholder="name">
	             <input class="l2" type="text" name="teacher" id="teacher" placeholder="teacher name">
	             <br>
	             <p><%= (request.getAttribute("mesaj") != null) ? request.getAttribute("mesaj") : "" %></p>
	             <div class="field padding-bottom--24">
	                  <input type="submit" name="submit" value="Add">
	             </div>
	             
	        </form>
        	
        </div>
        
        
        <section class="py-5 border-bottom" id="features" style="height:auto;">
            <div class="container px-5 my-5">
                <div class="row gx-5">
                    <div class="col-lg-4">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
                        <h2 class="h4 fw-bolder" >Users</h2>
                        <p style="font-size:22px;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Invidiosum nomen est, infame, suspectum. Sed mehercule pergrata mihi oratio tua. Quae similitudo in genere etiam humano apparet.</p>
                        <div class="alick">
                        	<a class="text-decoration-none" href="admin_users.jsp">
                            	View
                            	<i class="bi bi-arrow-right"></i>
                        	</a>
                        </div>
                    </div>
                    
                  <div class="col-lg-4 mb-5 mb-lg-0">
                        <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-building"></i></div>
                        <h2 class="h4 fw-bolder">Support - problems</h2>
                        <p style="font-size:22px;">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Invidiosum nomen est, infame, suspectum. Sed mehercule pergrata mihi oratio tua. Quae similitudo in genere etiam humano apparet.</p>
                        <div class="alick">
                        	<a class="text-decoration-none" href="admin_support.jsp">
                            	View
                            	<i class="bi bi-arrow-right"></i>
                        	</a>
                        </div>
                    </div>
                  
                </div>
            </div>
        </section>
	
	</body>


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