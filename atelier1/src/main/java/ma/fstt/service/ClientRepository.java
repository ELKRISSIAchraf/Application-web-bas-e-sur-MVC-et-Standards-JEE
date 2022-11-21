package ma.fstt.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ma.fstt.dao.SingletonConnection;
import ma.fstt.entities.Client;

public interface ClientRepository {
	

	public void ajouterClient(Client client) throws SQLException;
	public List<Client> getClients() throws SQLException ;
	public boolean deleteClient(int id) throws SQLException;
	public boolean updateClient(Client client ) throws SQLException;
	public Client trouverById(int id) throws SQLException;
	
}
