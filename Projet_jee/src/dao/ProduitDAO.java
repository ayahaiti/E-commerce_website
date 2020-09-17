package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produit;

public class ProduitDAO {
	ArrayList<Produit> list = new ArrayList<>();

	public ArrayList<Produit> getProducts(Connection con){
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql = "Select * from produit";
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
				String titre= rs.getString("titre");
				String category= rs.getString("categorie");
				String description= rs.getString("description");
				int prix= rs.getInt("price");
				String image= rs.getString("image");
				Produit p = new Produit();
				p.setCategory(category);
				p.setDescription(description);
				p.setId(id);
				p.setImage(image);
				p.setTitre(titre);
				p.setPrice(prix);
				list.add(p);
				p=null;
			}
			if (rs!= null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void deleteProduct(int id,Connection con){
		PreparedStatement st=null;
		String sql = "Delete from produit where id=?";
		//Execute the query
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			if (st != null) {
				st.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Produit findProduct(int id,Connection con){
		ResultSet m_ResultSet = null;
		PreparedStatement pstmt=null;
		Produit produit = new Produit();
		String sql = "select * from produit where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			m_ResultSet = pstmt.executeQuery();
			m_ResultSet.next();
				produit.setId(m_ResultSet.getInt("id"));
				produit.setTitre(m_ResultSet.getString("titre"));
				produit.setPrice(m_ResultSet.getInt("price"));
				produit.setCategory(m_ResultSet.getString("categorie"));
				produit.setDescription(m_ResultSet.getString("description"));
				produit.setImage(m_ResultSet.getString("image"));
				if (m_ResultSet != null) {
					m_ResultSet.close();
				}
				if (pstmt != null) {
					pstmt.close();
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produit;
	}

	public void updateProduct(Produit p,Connection con){
		PreparedStatement st=null;
		String sql = "update produit set titre=?,price=?,categorie=?,description=? where id=?";
		try{
			st = con.prepareStatement(sql);
			st.setString(1, p.getTitre());
			st.setInt(2, p.getPrice());
			st.setString(3, p.getCategory());
			st.setString(4, p.getDescription());
			st.setInt(5, p.getId());
			st.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addProduct(Produit p,Connection con){
		ResultSet m_ResultSet = null;
		PreparedStatement pst=null;
		String sql = "Insert into produit(titre,price,categorie,description,image) values(?,?,?,?,?)";
		try{
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getTitre());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getCategory());
			pst.setString(4, p.getDescription());
			pst.setString(5, p.getImage());
			pst.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
