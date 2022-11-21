package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LignedeCommande {
private int id_lignecmd;
@Override
public String toString() {
	return "LignedeCommande [id_lignecmd=" + id_lignecmd + ", id_pro=" + id_pro + ", id_cmd=" + id_cmd + ", qte_cmd="
			+ qte_cmd + "]";
}
public LignedeCommande(int id_lignecmd, int id_pro, int id_cmd, int qte_cmd) {
	super();
	this.id_lignecmd = id_lignecmd;
	this.id_pro = id_pro;
	this.id_cmd = id_cmd;
	this.qte_cmd = qte_cmd;
}
public LignedeCommande(int idPro, int idCmd, int qteCmd) {
	// TODO Auto-generated constructor stub
	this.id_pro = idPro;
	this.id_cmd = idCmd;
	this.qte_cmd = qteCmd;
}
public int getId_lignecmd() {
	return id_lignecmd;
}
public void setId_lignecmd(int id_lignecmd) {
	this.id_lignecmd = id_lignecmd;
}
public int getId_pro() {
	return id_pro;
}
public void setId_pro(int id_pro) {
	this.id_pro = id_pro;
}
public int getId_cmd() {
	return id_cmd;
}
public void setId_cmd(int id_cmd) {
	this.id_cmd = id_cmd;
}
public int getQte_cmd() {
	return qte_cmd;
}
public void setQte_cmd(int qte_cmd) {
	this.qte_cmd = qte_cmd;
}
private int id_pro ;
private int id_cmd;
private int qte_cmd;

}
