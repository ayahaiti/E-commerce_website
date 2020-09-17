<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/formconnexion.css" />" />
    </head>
    <body>
      <div class="c">
      <h1>Connexion</h1>
      </div>
        <form method="post" action="<c:url value="/connexion" />">
              
                <c:if test="${empty sessionScope.sessionUtilisateur && !empty requestScope.intervalleConnexions }">
                	<p class="info">(Vous ne vous êtes pas connecté(e) depuis ce navigateur depuis ${requestScope.intervalleConnexions})</p>
                </c:if>
				<div class="d">
                <label for="nom">Username <span class="requis">*</span></label>
                <input id="email" name="email" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
				</div>
				
				<div class="d">
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
                </div>
                
                <br />
				<div class="d">
                <button type="submit" class="bouton" >Connexion </button>
                <br />
                </div>
                <p>
	 				New to ebay? <a href="./inscription" style="color:#F24638;">Create Account</a>
	 			</p>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                	<p class="succes"></p>
                </c:if>
        </form>
    </body>
</html>