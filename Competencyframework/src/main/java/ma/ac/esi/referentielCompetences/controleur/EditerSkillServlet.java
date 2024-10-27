
package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;

public class EditerSkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditerSkillServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String idStr = request.getParameter("id");
	    System.out.println(idStr);
	    if (idStr != null && !idStr.isEmpty()) {
	        try {
	           
	            int id = Integer.parseInt(idStr);

	            String name = request.getParameter("name");
	            String description = request.getParameter("description");
	            String domain = request.getParameter("domain");
	            String level = request.getParameter("level");
	            String categorie = request.getParameter("categorie");

	            Skill skill = new Skill(name, description, domain, level, categorie);
	            skill.setId(id); 
	            SkillDAO skillDAO = new SkillDAO();
	            boolean success = skillDAO.editerSkill(skill);

	            if (success) {
	                response.sendRedirect("SkillServlet");
	            } else {
	                
	                response.getWriter().println("Échec de l'édition de la compétence.");
	            }
	        } catch (NumberFormatException e) {
	            // Gérer les erreurs de conversion d'ID en entier
	            response.getWriter().println("Erreur: ID de compétence invalide.");
	        }
	    } else {
	        // Afficher un message d'erreur si l'ID est manquant dans l'URL
	        response.getWriter().println("Erreur: ID de compétence manquant.");
	    }
	}


}
