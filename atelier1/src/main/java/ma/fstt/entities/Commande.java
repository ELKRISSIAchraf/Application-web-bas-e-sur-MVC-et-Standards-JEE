package ma.fstt.entities;

import java.util.Date;


import javax.enterprise.context.ApplicationScoped;
@ApplicationScoped
public class Commande {
private int id_cmd;
@Override
public String toString() {
	return "Commande [id_cmd=" + id_cmd + ", date_cmd=" + date_cmd + ", id_cli=" + id_cli + "]";
}
public Commande(int id_cmd, Date date_cmd, int id_cli) {
	super();
	this.id_cmd = id_cmd;
	this.date_cmd = date_cmd;
	this.id_cli = id_cli;
}
public Commande(Date date, int idClient) {
	// TODO Auto-generated constructor stub
	this.date_cmd = date;
	this.id_cli = idClient;
}
public int getId_cmd() {
	return id_cmd;
}
public void setId_cmd(int id_cmd) {
	this.id_cmd = id_cmd;
}
public Date getDate_cmd() {
	return date_cmd;
}
public void setDate_cmd(Date date_cmd) {
	this.date_cmd = date_cmd;
}
public int getId_cli() {
	return id_cli;
}
public void setId_cli(int id_cli) {
	this.id_cli = id_cli;
}
private Date date_cmd;
private int id_cli;
}
