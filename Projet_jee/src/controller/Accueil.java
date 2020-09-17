package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.ProduitDAO;
import dao.UtilisateurDAO;
import model.Produit;

public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String loginDB;
	private static String passwordDB;
	private static final String Accueil = "/WEB-INF/accueil.jsp";
	private static final String Inscription = "/WEB-INF/inscription.jsp";
	private static final String Connexion = "/WEB-INF/connexion.jsp";
	private static final String Homefurniture = "/WEB-INF/homefurniture.jsp";
	private static final String Clothing = "/WEB-INF/clothings.jsp";
	private static final String Hightech = "/WEB-INF/hightech.jsp";
	private static final String Pharmacy = "/WEB-INF/pharmacy.jsp";
	private static final String Mobiles = "/WEB-INF/mobiles.jsp";
	private static final String Laptops = "/WEB-INF/laptops.jsp";
	private static final String Sports = "/WEB-INF/sports.jsp";
	private static final String Jewelry = "/WEB-INF/jewelry.jsp";
	private static final String Games= "/WEB-INF/games.jsp";
	private static final String Garden = "/WEB-INF/garden.jsp";
	private static final String CheckProduct = "/WEB-INF/checkProduct.jsp";
	ArrayList<Produit> listeProduits = new ArrayList<>();
	HttpSession session;

	public Accueil() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goTo = request.getParameter("goTo");
		loginDB=getServletContext().getInitParameter("login");
		passwordDB=getServletContext().getInitParameter("password");
		if(goTo == null ) {
			ProduitDAO d = new ProduitDAO();
			Connection con=UtilisateurDAO.getConnectionFunction(loginDB, passwordDB);
			listeProduits = d.getProducts(con);
			session = request.getSession();
			session.setAttribute("list", listeProduits);
			request.getRequestDispatcher(Accueil).forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goTo = request.getParameter("goTo");
		String add=request.getParameter("add");
		if(goTo.equals("connexion")) {
			request.getRequestDispatcher(Connexion).forward(request, response);
		}
		
		if(goTo.equals("inscription")) {
			request.getRequestDispatcher(Inscription).forward(request, response);
		}
		
		if(goTo.equals("logout")) {
			session = request.getSession();
			session.setAttribute("session",null);
			
			request.getRequestDispatcher(Accueil).forward(request, response);
		}
		
		if( goTo.equals("mobiles") || goTo.equals("accueil") || goTo.equals("laptops") || goTo.equals("clothings") || goTo.equals("homefurniture") || goTo.equals("getproducts") || goTo.equals("games") || goTo.equals("garden") || goTo.equals("hightech") || goTo.equals("jewelry") || goTo.equals("pharmacy") || goTo.equals("sports") || goTo.equals("checkProduct")) {
			loginDB=getServletContext().getInitParameter("login");
			passwordDB=getServletContext().getInitParameter("password");
			ProduitDAO d = new ProduitDAO();
			Connection con=UtilisateurDAO.getConnectionFunction(loginDB, passwordDB);
			listeProduits = d.getProducts(con);
			request.setAttribute("list", listeProduits);
			if(add!=null){
			if(add.equals("addtopanier")){
				Integer a=(Integer) (session.getAttribute("panier"));
				if(a==null){
					session.setAttribute("panier",1);
				}
				else{
					a=a+1;
					session.setAttribute("panier",a);
				}
			}
			}
			if(goTo.equals("accueil"))
				request.getRequestDispatcher(Accueil).forward(request, response);
			if(goTo.equals("mobiles"))
				request.getRequestDispatcher(Mobiles).forward(request, response);
			if(goTo.equals("laptops"))
				request.getRequestDispatcher(Laptops).forward(request, response);
			if(goTo.equals("clothings"))
				request.getRequestDispatcher(Clothing).forward(request, response);
			if(goTo.equals("homefurniture"))
				request.getRequestDispatcher(Homefurniture).forward(request, response);
			if(goTo.equals("games"))
				request.getRequestDispatcher(Games).forward(request, response);
			if(goTo.equals("garden"))
				request.getRequestDispatcher(Garden).forward(request, response);
			if(goTo.equals("jewelry"))
				request.getRequestDispatcher(Jewelry).forward(request, response);
			if(goTo.equals("sports"))
				request.getRequestDispatcher(Sports).forward(request, response);
			if(goTo.equals("hightech"))
				request.getRequestDispatcher(Hightech).forward(request, response);
			if(goTo.equals("pharmacy"))
				request.getRequestDispatcher(Pharmacy).forward(request, response);
			if(goTo.equals("getproducts"))
				request.getRequestDispatcher("/WEB-INF/getproducts.jsp").forward(request, response);
			if(goTo.equals("checkProduct")){
				int id=Integer.parseInt(request.getParameter("id"));
				Produit produit=ProduitDAO.findProduct(id,UtilisateurDAO.getConnectionFunction(loginDB, passwordDB));
				session.setAttribute("title",produit.getTitre());
				session.setAttribute("description",produit.getDescription());
				session.setAttribute("image",produit.getImage());
				session.setAttribute("prix",produit.getPrice());
				request.getRequestDispatcher(CheckProduct).forward(request, response);
			}
		}
		
		}
	}
