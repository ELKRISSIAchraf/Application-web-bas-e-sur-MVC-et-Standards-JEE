package ma.fstt.entities;

public class Produit {
private int id_pro;
@Override
public String toString() {
	return "Produit [id_pro=" + id_pro + ", nom_pro=" + nom_pro + ", pu_pro=" + pu_pro + ", qte_pro=" + qte_pro + "]";
}
public Produit(int id_pro, String nom_pro, Double pu_pro, int qte_pro) {
	super();
	this.id_pro = id_pro;
	this.nom_pro = nom_pro;
	this.pu_pro = pu_pro;
	this.qte_pro = qte_pro;
}
public int getId_pro() {
	return id_pro;
}
public void setId_pro(int id_pro) {
	this.id_pro = id_pro;
}
public String getNom_pro() {
	return nom_pro;
}
public void setNom_pro(String nom_pro) {
	this.nom_pro = nom_pro;
}
public Double getPu_pro() {
	return pu_pro;
}
public void setPu_pro(Double pu_pro) {
	this.pu_pro = pu_pro;
}
public int getQte_pro() {
	return qte_pro;
}
public void setQte_pro(int qte_pro) {
	this.qte_pro = qte_pro;
}
private String nom_pro;
public Produit(String nom_pro, Double pu_pro, int qte_pro) {
	super();
	this.nom_pro = nom_pro;
	this.pu_pro = pu_pro;
	this.qte_pro = qte_pro;
}
private Double pu_pro;
private int qte_pro;
}
