package ma.fstt.service;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.entities.Produit;

public interface ProduitRepository {
	public  Produit trouverById(int id) throws SQLException;
	public void ajouterProduit( Produit pProduit) throws SQLException;
	public List<Produit> getProduits() throws SQLException;
	public boolean deleteProduit(int id)throws SQLException;
	public boolean updateProduit(Produit produit )throws SQLException;
	
}
