package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LignedeCommande;

public interface LignedeCommandeRepository {
	public  LignedeCommande trouverById(int id) throws SQLException;
	public void ajouterLignedeCommande( LignedeCommande  lignedecommande)throws SQLException;
	public List<LignedeCommande> getLignedeCommandes()throws SQLException ;
	public boolean deleteLignedeCommande(int id)throws SQLException;
	public boolean updateLignedeCommande(LignedeCommande lignedecommande )throws SQLException;
	
}
