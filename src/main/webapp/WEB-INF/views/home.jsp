<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Acceuil</title>
	
	<!-- core CSS -->	
	<link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/animate.min.css" rel="stylesheet"> 
    <link href="<%=request.getContextPath() %>/resources/css/lightbox.css" rel="stylesheet"> 
	<link href="<%=request.getContextPath() %>/resources/css/main.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/resources/css/responsive.css" rel="stylesheet">

   
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath() %>/resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath() %>/resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/resources/images/ico/apple-touch-icon-57-precomposed.png">
    
</head>
 <body>
	<header id="header">
        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.html">
                    	<h1><img src="#" alt="logo">zakaria</h1>
                    </a>
                    
                </div>
				<div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="<%=request.getContextPath() %>/">Home</a></li>
						<li><a href="#">A propos</a></li>
                        <li><a href="#">Projets</a></li>
	                    <li class="dropdown"><a href="#">Cat�gories <i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                                <c:forEach items="${categories}" var="cat">
									<li><a href="#">${cat.nomCategorie}</a></li>
								</c:forEach>
                            </ul>
                        </li>                    
						<li><a href="<%=request.getContextPath() %>/register">S'enregistrer</a></li> 
                        <li><a href="#">Se Connecter</a></li>                        
                    </ul>
                </div>
                
            </div><!--/.container-->
        </nav><!--/nav-->
    </header>
    
    <section id="home-slider">
        <div class="container">
            <div class="row">
                <div class="main-slider">
                    <div class="slide-text">
                        <h1>We Are Creative Nerds</h1>
                        <p>Boudin doner frankfurter pig. Cow shank bresaola pork loin tri-tip tongue venison pork belly meatloaf short loin landjaeger biltong beef ribs shankle chicken andouille.</p>
                        <a href="#" class="btn btn-common">Se Connecter</a>
                    </div>
                    <img src="<%=request.getContextPath() %>/resources/images/home/slider/hill.png" class="slider-hill" alt="slider image">
                    <img src="<%=request.getContextPath() %>/resources/images/home/slider/house.png" class="slider-house" alt="slider image">
                    <img src="<%=request.getContextPath() %>/resources/images/home/slider/sun.png" class="slider-sun" alt="slider image">
                    <img src="<%=request.getContextPath() %>/resources/images/home/slider/birds1.png" class="slider-birds1" alt="slider image">
                    <img src="<%=request.getContextPath() %>/resources/images/home/slider/birds2.png" class="slider-birds2" alt="slider image">
                </div>
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="<%=request.getContextPath() %>/resources/images/home/icon1.png" alt="">
                        </div>
                        <h2>Incredibly Responsive</h2>
                        <p>Ground round tenderloin flank shank ribeye. Hamkevin meatball swine. Cow shankle beef sirloin chicken ground round.</p>
                    </div>
                </div>
                <div class="col-sm-6 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="600ms">
                            <img src="<%=request.getContextPath() %>/resources/images/home/icon2.png" alt="">
                        </div>
                        <h2>Superior Typography</h2>
                        <p>Hamburger ribeye drumstick turkey, strip steak sausage ground round shank pastrami beef brisket pancetta venison.</p>
                    </div>
                </div>
                
            </div>
        </div>
    </section>
    <!--/#services-->
    
     <section id="action" class="responsive">
        <div class="vertical-center">
             <div class="container">
                <div class="row">
                    <div class="action take-tour">
                        <div class="col-sm-7 wow fadeInLeft" data-wow-duration="500ms" data-wow-delay="300ms">
                            <h1 class="title">Triangle Corporate Template</h1>
                            <p>A responsive, retina-ready &amp; wide multipurpose template.</p>
                        </div>
                        <div class="col-sm-5 text-center wow fadeInRight" data-wow-duration="500ms" data-wow-delay="300ms">
                            <div class="tour-button">
                                <a href="#" class="btn btn-common">Cr�er un projet</a>
                             </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
    
 
    <section id="portfolio">
        <div class="container">
            <div class="row">
            	<ul class="portfolio-filter text-center"></ul>
                <div class="portfolio-items">
                  <c:forEach items="${categories}" var="cat">
                    <div class="col-xs-6  portfolio-item branded logos">
                        <div class="portfolio-wrapper">
                            <div class="portfolio-single">
                                <div class="portfolio-thumb">
                                    <img src="photoCat?idCat=${cat.idCategorie}" class="img-responsive" alt="">
                                </div>
                                <div class="portfolio-view">
                                    <ul class="nav nav-pills">
                                        <li><a href="#"><i class="fa fa-link"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="portfolio-info ">
                                <h2 align="center">${cat.nomCategorie}</h2>
                            </div>
                        </div>
                    </div>
                  </c:forEach>    
                </div>
            </div>
        </div>
    </section>
    <!--/#portfolio-->
    
     <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="<%=request.getContextPath() %>/resources/images/home/under.png" class="img-responsive inline" alt="">
                </div>
               
                <div class="col-sm-12 text-center" align="center">
                    <div class="contact-info bottom">
                        <h2>Contacts</h2>
                        <address>
                        E-mail: <a href="mailto:lahyani.zakaria.lz@gmail.com">lahyani.zakaria.lz@gmail.com</a> <br> 
                        Phone: 0123456789 <br> 
                        </address>

                        <h2>Address</h2>
                        <address>
                        Unit C2, St.Vincent's Trading Est., <br> 
                        Feeder Road, <br> 
                        Bristol, BS2 0UY <br> 
                        United Kingdom <br> 
                        </address>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                        <p>&copy; Universit� d'Angers 2016. All Rights Reserved.</p>
                        <p>Designed by <a target="_blank" href="http://www.themeum.com">Themeum</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    
    
    
    
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main.js"></script>   
  </body>
</html>
