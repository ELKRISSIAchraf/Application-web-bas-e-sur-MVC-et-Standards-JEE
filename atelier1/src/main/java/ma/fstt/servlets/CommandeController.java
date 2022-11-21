package ma.fstt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class CommandeController
 */
@WebServlet("/CommandeController")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CommandeDAO commandeRepository= new CommandeDAO();
	private ClientDAO clientRepository= new ClientDAO();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");	 
        try {
            switch (action) {
            case "ajouter":
                ajoutercommande(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break;   
            case "ajouterCmd":
                pageajoutercommande(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break;   
            case "delete":
                deletecommande(request, response);
                break;          
            case "update":
               updatecommande(request, response);
                break;
            case "updateCmd":
                pageupdatecommande(request, response);
                 break;
            case "find":
                findcommande(request, response);
                break;

            default:
            	response.getWriter().append("Served ---------------------------list-----------------: ").append(request.getContextPath());
                listcommandes(request, response);
                break;
            
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
        
	}
	private void listcommandes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Commande> listcommandes = commandeRepository.getCommandes();
        List<Client> listclients = clientRepository.getClients();
        request.setAttribute("listclients", listclients);
        request.setAttribute("listcommandes", listcommandes);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("Commande/commande.jsp");
        dispatcher.forward(request, response);
      
	}
	private void ajoutercommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		java.util.Date date=  new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateCmd"));
		java.sql.Date SQLDate =  new java.sql.Date(date.getTime());
	//	new java.sql.Date(affiliate.getDate().getTime()))
		int idClient = Integer.parseInt(request.getParameter("idCli"));
		Commande commande = new Commande(SQLDate, idClient);
		commandeRepository.ajouterCommande(commande);
		response.sendRedirect("commande?action=list");
	}
	private void pageajoutercommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException, ServletException {
        List<Client> listclients = clientRepository.getClients();
        request.setAttribute("listclients", listclients);
        System.out.println(listclients);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Commande/addcommande.jsp");
	      dispatcher.forward(request, response);
	}
	 private void deletecommande(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        System.out.println(id);
	    //   Client client = new Client(id);
	        commandeRepository.deleteCommande(id);
	        response.sendRedirect("commande?action=list");
	    }
	 private void updatecommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 java.util.Date date=   new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateCmd"));
		 java.sql.Date SQLDate =  new java.sql.Date(date.getTime());
			int idClient = Integer.parseInt(request.getParameter("idCli"));
			Commande commande = new Commande(id,SQLDate, idClient);
	        commandeRepository.updateCommande(commande) ;
	        response.sendRedirect("commande?action=list");     
		 }
	 private void pageupdatecommande(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Commande commande =   commandeRepository.trouverById(id) ;
		 Client client= clientRepository.trouverById(commande.getId_cli());
		  request.setAttribute("commande", commande);
		  request.setAttribute("client", client);
		  List<Client> listclients = clientRepository.getClients();
	        request.setAttribute("listclients", listclients);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Commande/updatecommande.jsp");
	      dispatcher.forward(request, response); 
		 }
	 private void findcommande(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	       Commande commande = commandeRepository.trouverById(id);
	        request.setAttribute("commande", commande);
	        System.out.println(commande);
	        response.sendRedirect("commande?action=list");
	 
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
