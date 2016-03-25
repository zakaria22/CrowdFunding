<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>S'enregistrer</title>
	
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

	
    
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title" align="center">Liste des projets</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
	
	<section id="portfolio">
        <div class="container">
            <div class="row">
            	<ul class="portfolio-filter text-center">
                    <li><a class="btn btn-default active" href="#" data-filter="*">Tous</a></li>
                    <li><a class="btn btn-default" href="#" >Par Categorie</a></li>
                    <li><a class="btn btn-default" href="#" >Financé</a></li>
                    <li><a class="btn btn-default" href="#" >Non Financé</a></li>
                    <li><a class="btn btn-default" href="#" >Par Mot-clé</a></li>
                    <li><input id="key" type="text" class="search-form" autocomplete="off" placeholder="Search"> </li>
                   <li><button type="button" onclick=""><i class="fa fa-search"></i></button> </li>
                 </ul>
                
                <div class="portfolio-items">
                  <c:forEach items="${projets}" var="proj">
                  	<div class="col-sm-6 portfolio-item branded logos">
                        <div class="portfolio-wrapper">
                            <div class="portfolio-single">
                                <div class="portfolio-thumb">
                                    <img src="photoProj?idproj=${proj.idProjet}" class="img-responsive" alt="" height="42" width="42">
                                </div>
                                <div class="portfolio-view">
                                    <ul class="nav nav-pills">
                                        <li><a href="projet?idproj=${proj.idProjet}"><i class="fa fa-link"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="portfolio-info">
                                <h2 align="center">${proj.designation}</h2>
                            </div>
                        </div>
                    </div>
                  </c:forEach>    
                </div>
            </div>
        </div>
    </section>
    
    	<jsp:include page="footer.jsp"/>
    

</body>
</html>
 