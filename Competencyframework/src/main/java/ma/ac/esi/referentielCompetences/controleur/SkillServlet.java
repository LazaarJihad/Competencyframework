package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;
import java.util.List;

public class SkillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SkillServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method of SkillServlet is called.");
        // Récupération de la liste des compétences
        SkillDAO skillDAO = new SkillDAO(); 
        List<Skill> skills = skillDAO.getAllSkills();
        
        // Mise à jour de l'attribut "items" de la requête avec la liste des compétences
        request.setAttribute("items", skills);
        
        // Redirection vers la page SkillCrud.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String domain = request.getParameter("domain");
        String level = request.getParameter("level");
        String categorie = request.getParameter("categorie");
        SkillDAO skillDAO = new SkillDAO();
        Skill skill = new Skill(name, description, domain, level, categorie);

        boolean success = skillDAO.addSkill(skill);
        
        if (success) {
            
            request.setAttribute("message", "La compétence a été ajoutée avec succès.");
        } else {
            request.setAttribute("erreur", "Erreur lors de l'ajout de la compétence.");
        }
        
        List<Skill> skills = skillDAO.getAllSkills();
        request.setAttribute("items", skills);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
        dispatcher.forward(request, response);
    }
}
