<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

                    <a class="navbar-brand" href="<%=request.getContextPath() %>/">
                    	<h1><img src="#" alt="logo">zakaria</h1>
                    </a>
                    
                </div>
				<div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="<%=request.getContextPath() %>/">Home</a></li>
						<li><a href="<%=request.getContextPath() %>/projet/add">Créer Projet</a></li>
                        <li><a href="<%=request.getContextPath() %>/projet/liste_projets">Projets</a></li>
	                    <li class="dropdown"><a href="#">Catégories <i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                                <c:forEach items="${categories}" var="cat">
									<li><a href="<%=request.getContextPath() %>/projet/projetParCat?idCat=${cat.idCategorie}">${cat.nomCategorie}</a></li>
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
    