package controller;

import java.io.IOException;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import dao.UtilisateurDAO;
import model.Utilisateur;
import forms.ConnexionForm;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Accueil = "/WEB-INF/accueil.jsp";
	private static final String ATT_USER = "utilisateur";
	private static final String ATT_FORM = "form";
	private static final String ATT_SESSION_USER = "sessionUtilisateur";
	private static final String ATT_INTERVALE_CONNEXIONS = "intervalleConnexions";
	private static final String COOKIE_DERNIERE_CONNEXION = "derniereConnexion";
	private static final String FORMAT_DATE = "dd/MM/yyyy_HH:mm:ss";
	private static final String CHAMP_MEMOIRE = "memoire";
	private static final int COOKIE_MAX_AGE = 60 * 60 * 24 * 365;
	private static final String VUE = "/WEB-INF/connexion.jsp";
	private static String login;
	private static String password;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		login=getServletContext().getInitParameter("login");
		password=getServletContext().getInitParameter("password");
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login=getServletContext().getInitParameter("login");
		password=getServletContext().getInitParameter("password");
		ConnexionForm form = new ConnexionForm();

		Utilisateur utilisateur = form.connecterUtilisateur(request);

		HttpSession session = request.getSession();

		if (form.getErreurs().isEmpty()) {
				//session.setAttribute(ATT_SESSION_USER, utilisateur);
				session.setAttribute("session",session);
				session.setAttribute("username",utilisateur.getNom());
				this.getServletContext().getRequestDispatcher(Accueil).forward(request, response);
//				request.setAttribute(ATT_FORM, form);
//				request.setAttribute(ATT_USER, utilisateur);
//				session.setAttribute(ATT_SESSION_USER,utilisateur.getNom());
				
		}
		else{
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_USER, utilisateur);
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}

	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		Connexion.login = login;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Connexion.password = password;
	}
}