package forms;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import controller.Connexion;
import controller.Inscription;
import dao.UtilisateurDAO;
import model.Utilisateur;

public final class ConnexionForm {
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "motdepasse";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public String getResultat() {
		return resultat;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur connecterUtilisateur(HttpServletRequest request) {

		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);

		Utilisateur utilisateur = new Utilisateur();
		try {
			validationUser(email,motDePasse);
		}
		catch (Exception e) {
			setErreur(resultat,"Echec de la connexion.\n Username ou Mot de passe invalide");
		}
		utilisateur.setNom(email);
		utilisateur.setMotDePasse(motDePasse);
		if (erreurs.isEmpty()) {
			resultat = "Succes de la connexion.";
		} else {
			resultat = "Echec de la connexion.\n Username ou Mot de passe invalide.";
		}
		return utilisateur;
	}
	private void validationUser(String username,String password) throws Exception{
		Connexion a=new Connexion();
		String login=a.getLogin();
		String pass=a.getPassword();
		if (username == null || password==null || !UtilisateurDAO.checkIfUserExists(username,password,UtilisateurDAO.getConnectionFunction(login, pass))) {
			throw new Exception("Echec de la connexion.\n Username or Mot de passe invalide");
		}
	}

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}
