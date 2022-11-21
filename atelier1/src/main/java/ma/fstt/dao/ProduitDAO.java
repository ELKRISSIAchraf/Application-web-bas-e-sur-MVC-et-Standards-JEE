package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;

public class ProduitDAO implements ProduitRepository{
Connection conn ;
public ProduitDAO()   {
	try {
	try {
		this.conn=SingletonConnection.getConnection();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	@Override
	public Produit trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Produit produit= null;
        String sql = "SELECT * FROM produit WHERE id_pro= ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nom = resultSet.getString("nom_pro");
            Double pu = resultSet.getDouble("pu_pro");
            int qte= resultSet.getInt("qte_pro");
             
            produit = new Produit(id, nom, pu, qte);
        }
         
        resultSet.close();
        statement.close();
         
        return produit;
	}

	@Override
	public void ajouterProduit(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO produit (nom_pro, pu_pro, qte_pro) VALUES (?, ?, ?)";        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, produit.getNom_pro());
	        statement.setDouble(2, produit.getPu_pro());
	        statement.setInt(3, produit.getQte_pro());
	        statement.execute();
	}

	@Override
	public List<Produit> getProduits() throws SQLException {
		// TODO Auto-generated method stub
		List<Produit> listProduits= new ArrayList<>();       
        //String sql = "SELECT * FROM client";
        java.sql.Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM produit");    
        while (resultSet.next()) {
            int id = resultSet.getInt("id_pro");
            String nom = resultSet.getString("nom_pro");
            Double pu = resultSet.getDouble("pu_pro");
            int qte = resultSet.getInt("qte_pro");             
            Produit produit = new Produit(id, nom, pu, qte);
            listProduits.add(produit);
        }        
        resultSet.close();
        statement.close();
        return listProduits;
	}

	@Override
	public boolean deleteProduit(int id) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM produit where id_pro = ?";
         
	       
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1,id);
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	       
	        return rowDeleted;  
	}

	@Override
	public boolean updateProduit(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "UPDATE produit SET nom_pro = ?, pu_pro = ?,qte_pro = ?";
	        sql += " WHERE id_pro = ?"; 
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, produit.getNom_pro());
	        statement.setDouble(2, produit.getPu_pro());
	        statement.setInt(3, produit.getQte_pro());
	        statement.setInt(4,produit.getId_pro()); 
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;    
	}

}
