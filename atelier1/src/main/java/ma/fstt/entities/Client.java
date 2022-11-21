package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;


public class Client {
private int id_cli;
@Override
public String toString() {
	return "Client [id_cli=" + id_cli + ", nom_cli=" + nom_cli + ", tele_cli=" + tele_cli + ", adr_cli=" + adr_cli
			+ "]";
}
public int getId_cli() {
	return id_cli;
}
public void setId_cli(int id_cli) {
	this.id_cli = id_cli;
}
public String getNom_cli() {
	return nom_cli;
}
public void setNom_cli(String nom_cli) {
	this.nom_cli = nom_cli;
}
public String getTele_cli() {
	return tele_cli;
}
public void setTele_cli(String tele_cli) {
	this.tele_cli = tele_cli;
}
public String getAdr_cli() {
	return adr_cli;
}
public void setAdr_cli(String adr_cli) {
	this.adr_cli = adr_cli;
}
private String nom_cli;
public Client(int id_cli, String nom_cli, String tele_cli, String adr_cli) {
	super();
	this.id_cli = id_cli;
	this.nom_cli = nom_cli;
	this.tele_cli = tele_cli;
	this.adr_cli = adr_cli;
}
private String tele_cli;
public Client(String nom_cli, String tele_cli, String adr_cli) {
	super();
	this.nom_cli = nom_cli;
	this.tele_cli = tele_cli;
	this.adr_cli = adr_cli;
}
private String adr_cli;


}
