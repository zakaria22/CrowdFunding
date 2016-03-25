<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<section id="blog-details" class="padding-top">
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-7">
                    <div class="row">
                         <div class="col-md-12 col-sm-12">
							<div class="single-blog blog-details two-column">
							<div class="post-content overflow">
							    <div class="response-area">
							        <h2 class="bold" align="center">Commentaires</h2>
							        <f:form modelAttribute="comm" action="saveCommentaire"  method="post" >
										<div class="form-group">
											<f:textarea path="commentaire" class="form-control" required="required" placeholder="commentaire"/>
										</div>
										<div class="form-group">
												<f:select path="user.idUser" class="form-control" required="required" items="${users}" itemValue="idUser" itemLabel="userName"/>
										</div>
										<div class="form-group" style="display: none;">
											<f:input path="projet.idProjet" value="${projet.idProjet}"/>
										</div>
									
										<div class="form-group">
											<input type="submit" >
										</div>
										
									</f:form>
																        <ul class="media-list">
							          <li class="media">
							            <c:forEach items="${commentaires}" var="com">
								             <div class="post-comment">
								               <a class="pull-left" href="#">
								                  <img class="media-object"  src="photoUser?idUsr=${com.user.idUser}">
								               </a>
								               <div class="media-body">
									               <span><i class="fa fa-user"></i>Posted by <a href="#">${com.user.userName}</a></span>
									               <p>${com.commentaire}</p>
									               <ul class="nav navbar-nav post-nav">
									                 
									               </ul>
								               </div>
								             </div>
								         </c:forEach>
							          </li>
							        </ul>
							      </div>
							   </div>
						    </div>
						 </div>
					</div>
				</div>
			</div>
		</div>
    </section>