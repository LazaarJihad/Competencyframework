package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import ma.ac.esi.referentielCompetences.model.UtilisateurDAO;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;
import ma.ac.esi.referentielCompetences.model.Utilisateur;

public class ConnexionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateur = new Utilisateur();
       
        int  typeutilisateur =  utilisateurDAO.verifierutilisateur(username, password);
        System.out.println(typeutilisateur); 
        if(typeutilisateur > 0) {
        	utilisateur.setUsername(username);
        	utilisateur.setPassword(password);
        	utilisateur.setTypeUtilisateur(typeutilisateur);
        	System.out.println(utilisateur.getTypeUtilisateur());
        }
        else {
        	utilisateur= null;
        	
        }
        if (utilisateur != null) {
            if (utilisateur.getTypeUtilisateur() == 1) {
                SkillDAO skillDAO = new SkillDAO();
                String term = request.getParameter("search");
                List<Skill> skills;
                skills = skillDAO.getAllSkills();
                if (term != null && !term.isEmpty()) {
                    
                    skills = skillDAO.searchSkills(term);
                } else {
                   
                    skills = skillDAO.getAllSkills();
                }
                request.setAttribute("skills", skills);
                RequestDispatcher dispatcher = request.getRequestDispatcher("skillsimpleuser.jsp");
                dispatcher.forward(request, response);
            } 
          else if (utilisateur.getTypeUtilisateur() == 2) {
        	  response.sendRedirect("SkillServlet");

            }
        } else {
        	response.sendRedirect("connexion.jsp?error=loginerror");
        }
        
    }
}
