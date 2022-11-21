package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.service.LignedeCommandeRepository;

public class LignedeCommandeDAO implements LignedeCommandeRepository {
Connection conn ;
public LignedeCommandeDAO() {
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
	public LignedeCommande trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		LignedeCommande client = null;
        String sql = "SELECT * FROM lignedecommande WHERE id_lignecmd= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);        
        ResultSet resultSet = statement.executeQuery();    
        if (resultSet.next()) {
           int idPro = resultSet.getInt("id_pro");
           int idCmd = resultSet.getInt("id_cmd");
            int qte= resultSet.getInt("qte_cmd");      
            client = new LignedeCommande(id, idPro, idCmd, qte);
        }  
        resultSet.close();
        statement.close();
         
        return client;
	}
	@Override
	public void ajouterLignedeCommande(LignedeCommande lignedecommande) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO lignedecommande (id_pro, id_cmd, qte_cmd) VALUES (?, ?, ?)";        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, lignedecommande.getId_pro());
	        statement.setInt(2, lignedecommande.getId_cmd());
	        statement.setInt(3, lignedecommande.getQte_cmd());
	        statement.execute();
	}
	@Override
	public List<LignedeCommande> getLignedeCommandes() throws SQLException {
		// TODO Auto-generated method stub
		List<LignedeCommande> listClients= new ArrayList<>();       
        //String sql = "SELECT * FROM client";
        java.sql.Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM lignedecommande");    
        while (resultSet.next()) {
            int id = resultSet.getInt("id_lignecmd");
            int nom = resultSet.getInt("id_pro");
            int tele = resultSet.getInt("id_cmd");
            int adr = resultSet.getInt("qte_cmd");            
            LignedeCommande client = new LignedeCommande(id, nom, tele, adr);
            listClients.add(client);
        }     
        resultSet.close();
        statement.close();       
        return listClients;
	}
	@Override
	public boolean deleteLignedeCommande(int id) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM lignedecommande where id_lignecmd= ?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1,id);	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();	       
	        return rowDeleted; 
	}
	@Override
	public boolean updateLignedeCommande(LignedeCommande lignedecommande) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "UPDATE lignedecommande SET id_pro = ?, id_cmd = ?,qte_cmd = ?";
	        sql += " WHERE id_lignecmd = ?"; 
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, lignedecommande.getId_pro());
	        statement.setInt(2, lignedecommande.getId_cmd());
	        statement.setInt(3, lignedecommande.getQte_cmd());
	        statement.setInt(4, lignedecommande.getId_lignecmd()); 
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;    
	}

}
