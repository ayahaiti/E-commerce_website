package forms;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import controller.Inscription;
import dao.UtilisateurDAO;
import model.Utilisateur;

public class InscriptionForm {

	// Attributs

	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_PASS = "motdepasse";
	private static final String CHAMP_CONF = "confirmation";
	private static final String CHAMP_NOM = "nom";
	private String resultat;
	private HashMap<String, String> erreurs = new HashMap<String, String>();

	// Methodes

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {
		String email = getValeurChamp(request, CHAMP_EMAIL);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		String nom = getValeurChamp(request, CHAMP_NOM);

		Utilisateur utilisateur = new Utilisateur();

		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);

		try {
			validationMotsDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		utilisateur.setMotDePasse(motDePasse);

		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		utilisateur.setNom(nom);

		if (erreurs.isEmpty()) {
			resultat = "Succes de l'inscription.";
		} else {
			resultat = "echec de l'inscription.";
		}

		return utilisateur;
	}

	private void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entres sont differents, merci de les saisir a nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Le mot de passe doit faire au moins 3 caracteres.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe");
		}
	}

	private void validationNom(String nom) throws Exception {
		Inscription a=new Inscription();
		String login=a.getLogin();
		String password=a.getPassword();
		if (nom != null && nom.trim().length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caracteres.");
		}
		if(nom==null){
			throw new Exception("Merci de saisir un nom d'utilisateur.");
		}
		if(UtilisateurDAO.checkIfUserNameExists(nom,UtilisateurDAO.getConnectionFunction(login, password))){
			throw new Exception("Username already exists.");
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
			return valeur.trim();
		}
	}

	// Getters and Setters

	public String getResultat() {
		return resultat;
	}

	public HashMap<String, String> getErreurs() {
		return erreurs;
	}

}
