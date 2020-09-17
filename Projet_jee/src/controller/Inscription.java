package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDAO;
import forms.InscriptionForm;
import model.Utilisateur;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INSCRIPTION = "/WEB-INF/inscription.jsp";
	private static final String Accueil = "/Projet_jee/accueil";
	private static final String ATT_USER = "utilisateur";
	private static final String ATT_FORM = "form";
	private static String loginDB;
	private static String passwordDB;
	public Inscription() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginDB=getServletContext().getInitParameter("login");
		passwordDB=getServletContext().getInitParameter("password");
		this.getServletContext().getRequestDispatcher(INSCRIPTION).forward(request, response);
	}

	public String getLogin() {
		return loginDB;
	}

	public void setLogin(String login) {
		this.loginDB = login;
	}

	public String getPassword() {
		return passwordDB;
	}

	public void setPassword(String password) {
		this.passwordDB = password;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		loginDB=getServletContext().getInitParameter("login");
		passwordDB=getServletContext().getInitParameter("password");
		InscriptionForm form = new InscriptionForm();
		Utilisateur utilisateur = form.inscrireUtilisateur(request);
		request.setAttribute(ATT_USER, utilisateur);
		request.setAttribute(ATT_FORM, form);
		if (form.getErreurs().isEmpty()) {
			UtilisateurDAO.addUtilisateur(utilisateur.getEmail(),utilisateur.getMotDePasse(),utilisateur.getNom(), UtilisateurDAO.getConnectionFunction(loginDB, passwordDB));
			HttpSession session=request.getSession(true);
			session.setAttribute("session",session);
			session.setAttribute("username",utilisateur.getNom());
			response.sendRedirect(Accueil);
		} else {
			this.getServletContext().getRequestDispatcher(INSCRIPTION).forward(request, response);
		}
	}

}
