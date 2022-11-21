package ma.fstt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/ProduitController")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ProduitDAO produitRepository= new ProduitDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitController() {
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
                ajouterproduit(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break;  
            case "ajouterPro":
                pageajouterproduit(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break;  
            case "delete":
                deleteproduit(request, response);
                break;          
            case "update":
               updateproduit(request, response);
                break;
            case "updatePro":
                pageupdateproduit(request, response);
                 break; 
            case "find":
                findproduit(request, response);
                break;
                
            default:
            	response.getWriter().append("Served ---------------------------list-----------------: ").append(request.getContextPath());
                listproduits(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	private void listproduits(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Produit> listproduits = produitRepository.getProduits();
        request.setAttribute("listproduits", listproduits);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("Produit/produit.jsp");
        dispatcher.forward(request, response);
        
    }
	private void ajouterproduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nom = request.getParameter("nomPro");
		Double pu = Double.parseDouble(request.getParameter("puPro"));
		 int qte = Integer.parseInt(request.getParameter("qtePro"));
		Produit produit = new Produit(nom, pu, qte);
		produitRepository.ajouterProduit(produit);
		response.sendRedirect("produit?action=list");	
	}
	private void pageajouterproduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {	
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Produit/addproduit.jsp");
	      dispatcher.forward(request, response);
	}
	 private void deleteproduit(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        System.out.println(id);
	    //   Client client = new Client(id);
	        produitRepository.deleteProduit(id);
	        response.sendRedirect("produit?action=list");
	    }
	 private void updateproduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 String nom = request.getParameter("nomPro");
			Double pu = Double.parseDouble(request.getParameter("puPro"));
			 int qte = Integer.parseInt(request.getParameter("qtePro"));	 
	        Produit produit = new Produit(id,nom, pu, qte);
	        produitRepository.updateProduit(produit) ;
	        response.sendRedirect("produit?action=list");    
		 }
	 private void pageupdateproduit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Produit produit =   produitRepository.trouverById(id) ;
		  request.setAttribute("produit", produit);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Produit/updateproduit.jsp");
	      dispatcher.forward(request, response); 
		 }
	 private void findproduit(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	       Produit produit = produitRepository.trouverById(id);
	        request.setAttribute("produit", produit);
	        System.out.println(produit);
	        response.sendRedirect("produit?action=list");
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
