package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;

public class supprimerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
        String idStr = request.getParameter("id");
            int id = Integer.parseInt(idStr);
            SkillDAO dao = new SkillDAO();
            boolean success = dao.deleteskill(id);
            
            if (success) {
            	request.setAttribute("message", "La compétence a été supprimer avec succès.");
            } else {
            	  response.getWriter().println("Échec de l'édition de la compétence.");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("SkillServlet");
   		    dispatcher.forward(request, response);	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}