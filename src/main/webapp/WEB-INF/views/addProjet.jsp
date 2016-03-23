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
                            <h1 class="title" align="center">Créer un Nouveau Projet</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>



	<div class="col-md-6 col-md-offset-3" >
		<div class="contact-form bottom">
			<f:form modelAttribute="addProjet" action="saveNewProjet"  method="post" enctype="multipart/form-data">
				<div class="form-group">
					<f:input path="designation" class="form-control" required="required" placeholder="designation"/>
				</div>
				<div class="form-group">
					<f:textarea path="description" class="form-control" required="required" placeholder="description"/>
				</div>
				<div class="form-group">
					<f:select path="categorie.idCategorie" class="form-control" required="required" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie"/>
				</div>
				<div class="form-group">
					<f:input path="budget" class="form-control" required="required" placeholder="budget"/>
				</div>
				<div class="form-group">
					<f:input path="needed" class="form-control" required="required" placeholder="needed"/>
				</div>
				<div class="form-group">
					<c:if test="${projet.idProjet!=null}">
						<img src="photoProj?idP=${projet.idProjet}" class="img-responsive" alt="">
					</c:if>
					<input type="file" name="file"/>
				</div>
				<div class="form-group">
					<input type="submit" name="S'enregistrer" class="btn btn-submit"
						value="Faire Une demande">
				</div>
			</f:form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>

</body>
</html>
 