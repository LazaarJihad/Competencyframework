package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.profileDAO;

import java.io.IOException;

public class SupprimerProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	System.out.println("je suis appele");
        String IdProfileStr = request.getParameter("IdProfile");
            int IdProfile = Integer.parseInt(IdProfileStr);
            profileDAO dao = new profileDAO();
            boolean success = dao.deleteprofile(IdProfile);
            
            if (success) {
            	request.setAttribute("message", "Le profile a été supprimer avec succès.");
            } else {
            	  response.getWriter().println("Échec de l'édition du profile.");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("ProfileServlet");
   		    dispatcher.forward(request, response);	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}