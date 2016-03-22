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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/prettyPhoto.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/responsive.css">
    
</head>
  <body>
	<header id="header">
        <nav class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                  <a href="<%=request.getContextPath() %>/">logo</a>
                </div>
				
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">A propos</a></li>
                        <li><a href="#">Projets</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Catégories</a>
                            <ul class="dropdown-menu">
                            	<c:forEach items="${categories}" var="cat">
									<li><a href="#">${cat.nomCategorie}</a></li>
								</c:forEach>
                            </ul>
                        </li>
                        <li><a href="#">S'enregistrer</a></li> 
                        <li><a href="#">Se Connecter</a></li>                        
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
    </header>
    <section id="main-slider" class="no-margin">
        <div class="carousel slide">
            <ol class="carousel-indicators">
                <li data-target="#main-slider" data-slide-to="0" class="active"></li>
                <li data-target="#main-slider" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">

                <div class="item active" style="background-image: url(<%=request.getContextPath() %>/resources/images/slider/bg1.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Lorem ipsum dolor sit amet consectetur adipisicing elit</h1>
                                    <h2 class="animation animated-item-2">Accusantium doloremque laudantium totam rem aperiam, eaque ipsa...</h2>
                                    <a class="btn-slide animation animated-item-3" href="#">Read More</a>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="<%=request.getContextPath() %>/resources/images/slider/img1.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

                <div class="item" style="background-image: url(<%=request.getContextPath() %>/resources/images/slider/bg2.jpg)">
                    <div class="container">
                        <div class="row slide-margin">
                            <div class="col-sm-6">
                                <div class="carousel-content">
                                    <h1 class="animation animated-item-1">Lorem ipsum dolor sit amet consectetur adipisicing elit</h1>
                                    <h2 class="animation animated-item-2">Accusantium doloremque laudantium totam rem aperiam, eaque ipsa...</h2>
                                    <a class="btn-slide animation animated-item-3" href="#">Read More</a>
                                </div>
                            </div>

                            <div class="col-sm-6 hidden-xs animation animated-item-4">
                                <div class="slider-img">
                                    <img src="<%=request.getContextPath() %>/resources/images/slider/img2.png" class="img-responsive">
                                </div>
                            </div>

                        </div>
                    </div>
                </div><!--/.item-->

        </div><!--/.carousel-->
        <a class="prev hidden-xs" href="#main-slider" data-slide="prev"></a>
        <a class="next hidden-xs" href="#main-slider" data-slide="next"></a>
    </section><!--/#main-slider-->
    
    <script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.prettyPhoto.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.isotope.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/wow.min.js"></script>
  </body>
</html>
