package ma.fstt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.LignedeCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.entities.Produit;
/**
 * Servlet implementation class LignedeCommandeController
 */
@WebServlet("/LignedeCommandeController")
public class LignedeCommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private LignedeCommandeDAO lignedecommandeRepository= new LignedeCommandeDAO();
	private ProduitDAO produitRepository= new ProduitDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LignedeCommandeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");	 
        try {
            switch (action) {
            case "ajouter":
                ajouterlignedecommande(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "ajouterforcommande":
                ajouterforcommande(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "pageajouterforcommande":
                pageajouterforcommande(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "delete":
                deletelignedecommande(request, response);
                break;          
            case "update":
               updatelignedecommande(request, response);
                break;
            case "updateLcmd":
                pageupdatelignedecommande(request, response);
                 break;
            case "find":
                findlignedecommande(request, response);
                break;
            case "listforcommande":
                listforcommande(request, response);
                break;

            default:
            	response.getWriter().append("Served ---------------------------list-----------------: ").append(request.getContextPath());
                listlignedecommandes(request, response);
                break;
            
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
	}
	private void listlignedecommandes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
       
		List<LignedeCommande> listlignedecommandes =  lignedecommandeRepository.getLignedeCommandes();
		 List<Produit> listproduits = produitRepository.getProduits();
	        request.setAttribute("listproduits", listproduits);
	        request.setAttribute("listlignedecommandes", listlignedecommandes);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LignedeCommande/lignedecommande.jsp");
	        dispatcher.forward(request, response);
    }
	
	private void listforcommande(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		List<LignedeCommande> listlignedecommandes2=new ArrayList<LignedeCommande>() ;
		List<LignedeCommande> listlignedecommandes =  lignedecommandeRepository.getLignedeCommandes();
		for (LignedeCommande lcmd : listlignedecommandes) {
            if (lcmd.getId_cmd()==id) {
            	listlignedecommandes2.add(lcmd);
			}
        }
		 List<Produit> listproduits = produitRepository.getProduits();
	        request.setAttribute("listproduits", listproduits);
	        request.setAttribute("id", id);
	        request.setAttribute("listlignedecommandes", listlignedecommandes2);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("LignedeCommande/lignedecommande.jsp");
	        dispatcher.forward(request, response);
    }
	private void ajouterlignedecommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		int idCmd = Integer.parseInt(request.getParameter("idCmd"));
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
		LignedeCommande lignedecommande = new LignedeCommande(idPro, idCmd,qteCmd);
		lignedecommandeRepository.ajouterLignedeCommande(lignedecommande);
		response.sendRedirect("lignedecommande?action=list");
	}
	private void ajouterforcommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		int idCmd = Integer.parseInt(request.getParameter("id"));
		int idPro = Integer.parseInt(request.getParameter("idPro"));
		int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
		LignedeCommande lignedecommande = new LignedeCommande(idPro, idCmd,qteCmd);
		lignedecommandeRepository.ajouterLignedeCommande(lignedecommande);
		response.sendRedirect("lignedecommande?action=listforcommande&id="+idCmd);
	}
	private void pageajouterforcommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ServletException {
		List<Produit> listproduits = produitRepository.getProduits();
		int idCmd = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", idCmd);
        request.setAttribute("listproduits", listproduits);
        //System.out.println(listclients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("LignedeCommande/addlignedecommande.jsp");
	      dispatcher.forward(request, response);
	}
	 private void deletelignedecommande(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        System.out.println(id);
	    //   Client client = new Client(id);
	        LignedeCommande l= lignedecommandeRepository.trouverById(id);
	 lignedecommandeRepository.deleteLignedeCommande(id);

	        response.sendRedirect("lignedecommande?action=listforcommande&id="+l.getId_cmd());
	    }
	 private void updatelignedecommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 int idCmd = Integer.parseInt(request.getParameter("idCmd"));
			int idPro = Integer.parseInt(request.getParameter("idPro"));
			int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
			LignedeCommande lignedecommande = new LignedeCommande(id,idPro, idCmd,qteCmd);
	        lignedecommandeRepository.updateLignedeCommande(lignedecommande);
	        response.sendRedirect("lignedecommande?action=listforcommande&id="+idCmd);     
		 }
	 private void pageupdatelignedecommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 LignedeCommande lignedecommande =   lignedecommandeRepository.trouverById(id) ;
			 Produit produit= produitRepository.trouverById(lignedecommande.getId_pro());
			  request.setAttribute("lignedecommande", lignedecommande);
			  request.setAttribute("produit", produit);
			  List<Produit> listproduits = produitRepository.getProduits();
		        request.setAttribute("listproduits", listproduits);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("LignedeCommande/updatelignedecommande.jsp");
		      dispatcher.forward(request, response); 
		 }
	 private void findlignedecommande(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	       LignedeCommande lignedecommande = lignedecommandeRepository.trouverById(id);
	        request.setAttribute("lignedecommande", lignedecommande);
	        System.out.println(lignedecommande);
	        response.sendRedirect("lignedecommande?action=list");
	 
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
