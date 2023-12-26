<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Support</title>
		<link rel="stylesheet" type="text/css" href="navMenu.css">
		<link rel="stylesheet" type="text/css" href="support.css">
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">
		<link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
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
	    <li class="menu__item" style="--x: 34; --y: 19; "><a class="menu__link" href="student_profile.jsp">Profile</a></li>
	    <li class="menu__item" style="--x: 63; --y: 37;"><a class="menu__link" href="student_support.jsp">Support</a></li>
	    <li class="menu__item" style="--x: 19; --y: 48;"><a class="menu__link" href="student_mainPage.jsp">Home</a></li>
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
	
	<br><br>
	
	<body>
		<div class="card">
		  <h2>Tell us your problem</h2>
		  <br>
		  <p>Per facilisis varius, mauris sed ornare sodales nunc et et. Lacinia elit mattis pellentesque erat. Tempus cursus odio congue nisi malesuada curae;. Quam habitasse luctus sapien, nibh turpis hac. Hac quisque ridiculus imperdiet curabitur orci porttitor vehicula vehicula magna orci odio. Taciti suscipit tempor turpis maecenas leo primis magnis ultricies ultrices pharetra facilisi. In taciti duis scelerisque, tincidunt metus facilisis. Aliquet aliquet parturient primis vel taciti at. Vel natoque, eget fermentum. Taciti mus ultrices magna quisque accumsan dui ad litora mi.

				Gravida himenaeos venenatis tempor elementum mi tincidunt nascetur suspendisse vestibulum, hac semper mus? Sodales vestibulum ullamcorper sodales blandit mus congue sit. At litora et eros mus orci. Quisque habitant aptent nascetur ultrices id est phasellus. Potenti cras et ad mauris fames eros aptent turpis fringilla montes hac class. Ridiculus iaculis commodo sit tempus inceptos duis dictum phasellus condimentum porttitor commodo adipiscing. Sociis accumsan cum rutrum duis ut. Fermentum et risus vestibulum quis lacinia montes id tincidunt? Pellentesque phasellus per suspendisse tempus fermentum condimentum est montes non ad. Metus ultrices imperdiet mus a cubilia bibendum molestie ac curae; sapien?
				
				Cum sit ipsum conubia. Massa magnis etiam vitae bibendum! Dis sodales facilisis egestas sed cursus congue vitae. Per neque adipiscing amet fringilla senectus maecenas imperdiet nostra! Adipiscing, placerat sapien eleifend primis diam facilisis consequat parturient. Magnis penatibus scelerisque turpis porttitor dictum fames potenti pretium lobortis velit diam fusce? Per habitant eu magna leo vulputate; quis venenatis ultricies. Inceptos interdum netus duis sit platea, varius nec cursus? Laoreet elementum semper; blandit duis senectus ante posuere sociis sem. Iaculis purus lacinia congue eros. Hendrerit semper imperdiet fermentum auctor etiam dolor dui urna morbi. Dapibus, tristique at.
				
				At parturient consectetur curabitur torquent condimentum tristique sapien tempus metus integer. Dolor gravida eros elit tempus dui rhoncus conubia facilisi non euismod vitae vivamus. Mauris dictumst consequat enim aliquet. Eros inceptos nascetur diam tortor amet congue curabitur nisi conubia velit. Aenean penatibus enim ut sit vitae nostra vivamus posuere? Aliquet mattis porta nullam quam nostra mus dis. Habitasse sed varius iaculis fames platea. Habitant dui fringilla volutpat ligula, donec quis nulla! Velit suspendisse facilisis facilisi libero aptent massa praesent nulla maecenas viverra ante. Tortor posuere erat ridiculus etiam fermentum.
				
				Suscipit massa egestas parturient. Ut odio aenean semper eget magnis accumsan ante ipsum euismod, hac luctus bibendum. Primis dictum torquent netus praesent cum nibh tristique mauris. Sociosqu malesuada pulvinar enim vehicula egestas consequat. Massa proin fames tristique nascetur. Neque ante cras vulputate facilisis mollis libero accumsan. Elit nisl lacinia ultricies accumsan elementum fringilla quis nec luctus vel himenaeos.
			</p>
		<br>	
		  
		  <div class="row">
			<form action="Support" method="get">
				<div class="col">
			      <div class="form-group">
			        <label id="mesaj" name="mesaj">Describe your problem</label>
			        <textarea name="problem" id="problem" style="height: 163px;
						width: 500px;
						position: absolute;" id="problem">
					</textarea>
					
			      </div>
			    </div>
		    
				<br>
			    <div class="col" style="margin-left: 550px; width: 300px;">
			      <input type="submit" value="Submit">
			    </div>
			 </form>
			  
			</div>
			<br>
			
			
		    
		</div>
	
	
	</body>



	<footer class="relative bg-blueGray-200 pt-8 pb-6">
	  <div class="container mx-auto px-4">
	    <div class="flex flex-wrap text-left lg:text-left">
	      <div class="w-full lg:w-6/12 px-4">
	        <h4 class="text-3xl fonat-semibold text-blueGray-700">Let's learn together!</h4>
	        <h5 class="text-lg mt-0 mb-2 text-blueGray-600">
	          Use our platform and everything is going to be great!
	        </h5>
	        
	      </div>
	      <div class="w-full lg:w-6/12 px-4">
	        <div class="flex flex-wrap items-top mb-6">
	          <div class="w-full lg:w-4/12 px-4 ml-auto">
	            <span class="block uppercase text-blueGray-500 text-sm font-semibold mb-2">Useful Links</span>
	            <ul class="list-unstyled">
	              <li>
	                <a class="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm" href="gc.jsp">General conditions</a>
	              </li>
	              <li>
	                <a class="text-blueGray-600 hover:text-blueGray-800 font-semibold block pb-2 text-sm" href="tc.jsp">Terms and conditions</a>
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