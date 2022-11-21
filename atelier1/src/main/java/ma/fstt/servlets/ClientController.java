package ma.fstt.servlets;

import java.awt.desktop.SystemEventListener;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.*;
import ma.fstt.service.ClientRepository;

/**
 * Servlet implementation class ClientController
 */

@WebServlet("/ClientController")

public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientDAO clientRepository=new ClientDAO();

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served athhhhhhhhhhhhh: ").append(request.getContextPath());
		String action = request.getParameter("action");	 
        try {
            switch (action) {
            case "ajouter":
                ajouterclient(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "ajouterCli":
                pageajouterclient(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "updateCli":
                pageupdateclient(request, response);
            	//response.getWriter().append("--------------------------------ajouter ").append(request.getContextPath());
                break; 
            case "delete":
                deleteclient(request, response);
                break;          
            case "update":
               updateclient(request, response);
                break;
            case "find":
                findclient(request, response);
                break;
                
            default:
            	response.getWriter().append("Served ---------------------------list-----------------: ").append(request.getContextPath());
                listClients(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
	private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Client> listclients = clientRepository.getClients();
       
        //response.getWriter().append((CharSequence) listclients).append(request.getContextPath());
       //RequestDispatcher dispatcher = request.getRequestDispatcher(null);
        // dispatcher.forward(request, response);
        System.out.println(listclients);
      /*  PrintWriter out= response.getWriter();
        out.println("<html><body>");
        out.println("<li> Nom:"+listclients.toString()+"</li>");
        out.println("</html></body>");*/
        request.setAttribute("listclients", listclients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Client/client.jsp");
      dispatcher.forward(request, response);
    }
	private void ajouterclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nom = request.getParameter("nomCli");
		String tele = request.getParameter("teleCli");
		String adr = request.getParameter("adrCli");
		Client client = new Client(nom, tele, adr);
		clientRepository.ajouterClient(client);
		response.sendRedirect("client?action=list");	
	}
	private void pageajouterclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {	
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Client/addclient.jsp");
	      dispatcher.forward(request, response);
	}
	 private void deleteclient(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        System.out.println(id);
	    //   Client client = new Client(id);
	        clientRepository.deleteClient(id);
	        response.sendRedirect("client?action=list"); 
	    }
	 private void updateclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nomCli");
			String tele = request.getParameter("teleCli");
			String adr = request.getParameter("adrCli");
		 
	        Client client = new Client(id,nom, tele, adr);
	        clientRepository.updateClient(client) ;
	        response.sendRedirect("client?action=list");  
		 }
	 private void pageupdateclient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Client client =   clientRepository.trouverById(id) ;
		  request.setAttribute("client", client);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Client/updateclient.jsp");
	      dispatcher.forward(request, response); 
		 }
	 private void findclient(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	       Client client = clientRepository.trouverById(id);
	        request.setAttribute("client", client);
	        System.out.println(client);
	        response.sendRedirect("client?action=list");
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
