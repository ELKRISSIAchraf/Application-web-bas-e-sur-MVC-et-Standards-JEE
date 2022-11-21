package ma.fstt.dao;

import java.sql.Connection;


import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;

public class CommandeDAO implements CommandeRepository{
 
	Connection conn ;
	public CommandeDAO()   {
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
	public Commande trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Commande commande = null;
        String sql = "SELECT * FROM commande WHERE id_cmd= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id); 
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            Date date = resultSet.getDate("date_cmd");
            int idCli = resultSet.getInt("id_cli");
           
             
            commande = new Commande(id, date, idCli);
        }
         
        resultSet.close();
        statement.close();
         
        return commande;
	}

	@Override
	public void ajouterCommande(Commande commande) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO commande (date_cmd, id_cli) VALUES (?, ?)";        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setDate(1,(java.sql.Date) commande.getDate_cmd());
	        statement.setInt(2, commande.getId_cli());
	        statement.execute();
	}

	@Override
	public List<Commande> getCommandes() throws SQLException {
		// TODO Auto-generated method stub
List<Commande> listCommandes= new ArrayList<>();
        
        //String sql = "SELECT * FROM client";

        java.sql.Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM commande");
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id_cmd");
            Date date= resultSet.getDate("date_cmd");
            int idCli = resultSet.getInt("id_cli"); 
            Commande commande = new Commande(id, date, idCli);
            listCommandes.add(commande);
        }
         
        resultSet.close();
        statement.close();
         
      
         
        return listCommandes;
	}

	@Override
	public  boolean deleteCommande(int id) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "DELETE FROM commande where id_cmd = ?";
         
	       
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1,id);
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	       
	        return rowDeleted;  
	}

	@Override
	public boolean updateCommande(Commande commande) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "UPDATE commande SET date_cmd = ?, id_cli = ?";
	        sql += " WHERE id_cmd = ?"; 
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setDate(1, (java.sql.Date) commande.getDate_cmd());
	        statement.setInt(2,  commande.getId_cli());
	        statement.setInt(3,  commande.getId_cmd());
	       
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;    
		
	}

}
