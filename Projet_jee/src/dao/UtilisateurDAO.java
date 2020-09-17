package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import org.mindrot.jbcrypt.BCrypt;

import model.Utilisateur;


public class UtilisateurDAO {
	private final static int saltedValue=12;
	public static  Connection getConnectionFunction(String login,String password){
		Connection cn=null;
		System.out.println("-------- PostgreSQL "+ "JDBC Connection Testing ------------");
		try{
			Class.forName("org.postgresql.Driver");
		}

		catch(ClassNotFoundException e){
			System.out.println("Where is your PostgreSQL JDBC Driver? "+ "Include in your library path!");
			e.printStackTrace();
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		try{
			
			cn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:"+5432+"/projetjee",login,password);
		}
		catch(SQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (cn != null) {
			System.out.println("You made it, take control of your database now!");
		}
		else{
			System.out.println("Failed to make connection!");
		}
		return cn;
	}
	public static boolean checkIfUserNameExists(String usernom,Connection cn){
			boolean exists=false; 
			ResultSet m_ResultSet = null;
			String query = "";
			PreparedStatement p=null;
			query = "SELECT * FROM public.\"user\" WHERE username =?" ;
			//Execute the query
			try {
				p=cn.prepareStatement(query);
				p.setString(1,usernom);
				m_ResultSet = p.executeQuery();
				//Loop through the results
				while (m_ResultSet.next()) {
						exists=true;
				}

				if (m_ResultSet != null) {
					m_ResultSet.close();
				}
				if (p != null) {
					p.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return exists;
	}

	public static void addUtilisateur(String email,String password,String username,Connection cn){
		Statement statement = null;
		String salt=BCrypt.gensalt(saltedValue);
		String hashedPass=BCrypt.hashpw(password,salt);
		String insertTableSQL = "INSERT INTO public.\"user\" (email,password,username)"
				+ "VALUES ('"+email+"','"+hashedPass+"','"+username+"')";
		try {
			statement =cn.createStatement();
			System.out.println(insertTableSQL);
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean checkIfUserExists(String email, String motDePasse,
			Connection connectionFunction) {
		boolean exists=false; 
		ResultSet m_ResultSet = null;
		String query = "";
		PreparedStatement p=null;
		query = "SELECT * FROM Public.\"user\" WHERE username =? " ;
		//Execute the query
		try {
			p=connectionFunction.prepareStatement(query);
			p.setString(1,email);
			m_ResultSet = p.executeQuery();
			//Loop through the results
			while (m_ResultSet.next()) {
					exists=BCrypt.checkpw(motDePasse,m_ResultSet.getString(3));	
			}

			if (m_ResultSet != null) {
				m_ResultSet.close();
			}
			if (p != null) {
				p.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return exists;
	}

}
