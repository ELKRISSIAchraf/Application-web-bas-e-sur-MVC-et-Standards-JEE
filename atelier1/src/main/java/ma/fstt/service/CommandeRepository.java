package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository {
	
	public void ajouterCommande( Commande  commande)throws SQLException;
	public List<Commande> getCommandes() throws SQLException;
	public boolean deleteCommande(int id)throws SQLException;
	public boolean updateCommande(Commande commande )throws SQLException;
	public Commande trouverById(int id) throws SQLException;
}
