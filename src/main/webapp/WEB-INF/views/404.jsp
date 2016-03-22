
        
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
	<jsp:include page="header.jsp"/>
	
    <section id="error-page">
        <div class="error-page-inner">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="text-center">
                            <div class="bg-404">
                                <div class="error-image">                                
                                    <img class="img-responsive" src="<%=request.getContextPath() %>/resources/images/404.png" alt="">  
                                </div>
                            </div>
                            <h2>PROJECT  NOT  FOUND</h2>
                            <p>No project in this category.</p>
                            <a href="<%=request.getContextPath() %>/" class="btn btn-error">RETURN TO THE HOMEPAGE</a>
                            <div class="social-link">
                                <span><a href="#"><i class="fa fa-facebook"></i></a></span>
                                <span><a href="#"><i class="fa fa-twitter"></i></a></span>
                                <span><a href="#"><i class="fa fa-google-plus"></i></a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/main.js"></script>   
  </body>
</html>
        