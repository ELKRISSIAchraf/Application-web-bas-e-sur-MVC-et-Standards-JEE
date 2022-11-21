package ma.fstt.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.mysql.cj.xdevapi.Statement;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

public class ClientDAO implements ClientRepository{
	Connection conn;
	public ClientDAO()  {
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
	public Client trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Client client = null;
        String sql = "SELECT * FROM client WHERE id_cli= ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String nom = resultSet.getString("nom_cli");
            String tele = resultSet.getString("tele_cli");
            String adr= resultSet.getString("adr_cli");
             
            client = new Client(id, nom, tele, adr);
        }
         
        resultSet.close();
        statement.close();
         
        return client;
	}

	@Override
	public void ajouterClient(Client client) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO client (nom_cli, tele_cli, adr_cli) VALUES (?, ?, ?)";        
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, client.getNom_cli());
	        statement.setString(2, client.getTele_cli());
	        statement.setString(3, client.getAdr_cli());
	    
	        statement.execute();
	        System.out.println("gooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooood");
	}

	@Override
	public List<Client> getClients() throws SQLException {
		 //conn=SingletonConnection.getConnection();
		List<Client> listClients= new ArrayList<>();       
        //String sql = "SELECT * FROM client";
        java.sql.Statement statement =conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM client");    
        while (resultSet.next()) {
            int id = resultSet.getInt("id_cli");
            String nom = resultSet.getString("nom_cli");
            String tele = resultSet.getString("tele_cli");
            String adr = resultSet.getString("adr_cli");
             
            Client client = new Client(id, nom, tele, adr);
            listClients.add(client);
        }
         
        resultSet.close();
        statement.close();
         
      
         
        return listClients;
	}

	@Override
	public boolean deleteClient(int id) throws SQLException {
		 String sql = "DELETE FROM client where id_cli = ?";
         
	       
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1,id);
	         
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	       
	        return rowDeleted;  
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateClient(Client client) throws SQLException {
		 String sql = "UPDATE client SET nom_cli = ?, tele_cli = ?,adr_cli = ?";
	        sql += " WHERE id_cli = ?"; 
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, client.getNom_cli());
	        statement.setString(2, client.getTele_cli());
	        statement.setString(3, client.getAdr_cli());
	        statement.setInt(4, client.getId_cli()); 
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;    
		// TODO Auto-generated method stub
		
	}

}
