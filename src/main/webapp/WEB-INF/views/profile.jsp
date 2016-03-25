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
                            <h1 class="title">About   ${user.userName}</h1>
                            <p>Our Clients love to work with us.</p>
                        </div>
                     </div>
                </div>
            </div>
        </div>
   </section>
   
   <section id="about-company" class="padding-top wow fadeInUp" data-wow-duration="400ms" data-wow-delay="400ms">
        <div class="container">
            <div class="row">
                <div class="col-md-6 text-left">
                    <img class="margin-bottom"  src="photoUser?idUsr=${user.idUser}" width="225" height="230">
                </div>
                <div class="col-md-6 ">
                        <h2>Contacts</h2>
                        <h3>
                        E-mail: <a href="mailto:${user.email}">${user.email}</a> <br> 
                        Phone: ${user.tel} <br> 
                        </h3>
                        <h2>Address</h2>
                        <h3>
                        ${user.adresse} <br> 
                        </h3>
                    </div>
            </div>
        </div>
    </section>
    <br>    <br>
        <br>
        <br>
        
        <section id="clients">
		        <div class="container">
		            <div class="row">
		                <div class="col-sm-12">
		                    <div class="clients text-center wow fadeInUp" data-wow-duration="500ms" data-wow-delay="300ms">
		                        <p><img src="<%=request.getContextPath() %>/resources/images/home/clients.png" class="img-responsive" alt=""></p>
		                        <h1 class="title">Happy User</h1>
		                        <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br> Ut enim ad minim veniam, quis nostrud </p>
		                    </div>
						</div>
					</div>
				</div>
			</section>
			
			
    <section id="action">
        <div class="vertical-center">
             <div class="container">
                <div class="row">
                    <div class="action count">
                        <div class="col-sm-6 text-center wow bounceIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <c:if test="${uprojets!=null}">
                            	<h1 class="timer bold"  data-speed="3000" >${uprojets}</h1>   
                            </c:if>
                            <c:if test="${uprojets==null}">
                            	<h1 class="timer bold"  data-speed="3000" >0</h1>   
                            </c:if>
                            <h3>Projets</h3>
                        </div>
                        <div class="col-sm-6 text-center wow bounceIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                            <c:if test="${ucontrib!=null}">
                            	<h1 class="timer bold"  data-speed="3000" >${ucontrib}</h1>   
                            </c:if>
                            <c:if test="${ucontrib==null}">
                            	<h1 class="timer bold"  data-speed="3000" >0</h1>   
                            </c:if>
                            <h2>Contribution</h2> 
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#action-->
 
  
  	
  		<div id="accordion-container" class="col-md-6 col-md-offset-3">
                <h2 class="page-header">Projets : </h2>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                    Les projets auxquelles ${user.userName} est admin : 
                                
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                            	<table class="table table-striped">
								  <thead>
								    <tr>
								      <th>Nom de Projet</th>
								      <th>Cost</th>
								      <th>financé</th>
								    </tr>
								  </thead>
								  <c:forEach items="${listPro}" var="p">
									  <tbody>
									 	<th>${p.designation}</th>
									 	<th>${p.budget}</th>
									 	<c:if test="${p.financed!=true}">
									 		<th>Pas encore</th>									 		
									 	</c:if>
									 	<c:if test="${p.financed==true}">
									 		<th>Yes,et il est content :D</th>									 		
									 	</c:if>
									  </tbody>
								  </c:forEach>
								</table>
                            </div>
                        </div>
                    </div>
                   
                </div><!--/#accordion-->
            </div>
            
                                
  
    
    
	<jsp:include page="footer.jsp"/>
</body>
</html>
 