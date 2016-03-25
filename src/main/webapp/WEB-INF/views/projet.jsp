<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<sec:authentication var="user" property="principal" />

<c:set var="userAuth">
	<sec:authentication property="principal.username" /> 
</c:set>


    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title" align="center">Projet Seléctionné</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>



	<section id="portfolio-information" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <img src="photoProj?idproj=${projet.idProjet}" class="img-responsive" alt="">
                    <div class="row">
                    
                    
                    	<sec:authorize access="isAuthenticated()">
	                    	<c:if test="${projet.user.userName}==${userAuth}">
	                    		<div class="col-md-4 live-preview" >
								 	<a href="edit?idP=${projet.idProjet}" class="btn btn-lg btn-default">modifier</a>
								  	<a href="#" class="btn btn-common uppercase ">supprimer</a>
							  	</div>
	                    	</c:if> 
					    </sec:authorize>
					    
					    
					  </div>  
                </div>
                <div class="col-sm-6">
                    <div class="project-name overflow">
                        <h2 class="bold">${projet.designation}</h2>
                    </div>
                    <div class="project-info overflow">
                        <h3>Description:</h3>
                        <p>${projet.description}</p>
                        <ul class="elements">
                            <li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                            <li><i class="fa fa-angle-right"></i> Donec tincidunt felis quis ipsum porttitor, non rutrum lorem rhoncus.</li>
                            <li><i class="fa fa-angle-right"></i> Nam in quam consectetur nulla placerat dapibus ut ut nunc.</li>
                        </ul>
                    </div>
                    <div class="skills overflow">
                        <h3>Catégorie:</h3>
                        <ul class="nav navbar-nav navbar-default">
                            <li><a href="#"><i class="fa fa-check-square"></i>${projet.categorie.nomCategorie}</a></li>
                        </ul>
                    </div>
                    <div class="client overflow">
                        <h3>Admin:</h3>
                        <ul class="nav navbar-nav navbar-default">
                            <li><a href="<%=request.getContextPath() %>/profile/?idUSer=${projet.user.idUser}"><i class="fa fa-bolt"></i>${projet.user.userName}</a></li>
                        </ul>
                    </div>
                    
                    <div class="price-table">
			            <div class="row">
			                <div class="col-md-6">
			                    <div class="single-price price-one">
			                        <div class="table-heading">
			                            <p class="plan-name">budget</p>
			                            <p class="plan-price"><span class="dollar-sign">$</span><span class="price">${projet.budget}</span></p>
			                        </div>
			                    </div>
			                </div>
			                <div class="col-md-6">
			                    <div class="single-price price-two">
			                        <div class="table-heading">
			                            <p class="plan-name"> Manqué</p>
			                            <p class="plan-price"><span class="dollar-sign">$</span><span class="price">${projet.needed}</span></p>
			                        </div>                        
			                    </div>
			                </div>
			                
							<f:form modelAttribute="contribution" action="saveCont"  method="post" id="myForm">
								<div class="form-group">
									<f:input path="sommeDonnee" class="form-control" required="required" placeholder="somme"/>
								</div>
								<div class="form-group">
										<f:select path="user.idUser" class="form-control" required="required" items="${users}" itemValue="idUser" itemLabel="userName"/>
								</div>
								<div class="form-group" style="display: none;">
									<f:input path="projet.idProjet" value="${projet.idProjet}"/>
								</div>
							</f:form>
			                <div class="col-md-6 col-md-offset-3">
			                    <div class="single-price price-three">
									<a href="javascript: myFunction()" onclick="" class="btn btn-buynow">Contribuer</a>
								</div>
			                </div>                       
			              </div>
			          </div>
			       </div>
                </div>
            </div>
   
</section>
    
    
    <jsp:include page="commentaire.jsp"/>
    	<jsp:include page="footer.jsp"/>
    
<script>
	function myFunction() {
	    document.getElementById("myForm").submit();
	}
</script> 
</body>
</html>
 