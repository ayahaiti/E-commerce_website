<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="inc/formInscription.css" />
    </head>
    <body>
    	<div class="b">
                <h2>Inscription</h2>
            </div>
        <form method="post" action="inscription">
				<div class="a">
                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="<c:out value="${utilisateur.email}" />" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />
				</div>
				<div class="a">
                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />
				</div>
				
				<div class="a">
                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                </div>
				<div class="a">
                <label for="nom">Nom d'utilisateur<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}" />" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
				</div>
				<div class="a">
                <button type="submit" class="bouton" >Inscription</button>
                </div>
                <br/>
                <br/>
                <br/>
                You already have an account? <a href="./connexion"  style="color:#F24638;">Connexion</a>
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
        </form>
    </body>
</html>