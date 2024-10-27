package ma.ac.esi.referentielCompetences.controleur;


import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import ma.ac.esi.referentielCompetences.model.profile;
import ma.ac.esi.referentielCompetences.model.profileDAO;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

public class AssociateSkillsToProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la liste des profils
        profileDAO profileDAO = new profileDAO();
        List<profile> profiles = profileDAO.getAllprofile();
        request.setAttribute("profiles", profiles);

        // Récupérer la liste des compétences
        SkillDAO skillDAO = new SkillDAO();
        List<Skill> skills = skillDAO.getAllSkills();
        request.setAttribute("skills", skills);

        // Afficher la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("AssociateSkillsToProfile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("servlet est appeler");
        String nomProfile = request.getParameter("nomprofile");
        double salaire = Double.parseDouble(request.getParameter("salaire"));
        String[] selectedSkills = request.getParameterValues("skills");
        profileDAO profileDAO = new profileDAO();
        int profileId = profileDAO.trouveridprofile(nomProfile, salaire);
        System.out.println( profileId);
        boolean success = true;
        for (String skill : selectedSkills) {
            String[] skillInfo = skill.split(",");
            String skillName = skillInfo[0];
            String description = skillInfo[1];
            String level = skillInfo[2];
            String domain = skillInfo[3];
            System.out.println(skillName);
            System.out.println(description);
            System.out.println(level);
            System.out.println(domain);
            SkillDAO skillDAO = new SkillDAO();
            int skillId = skillDAO.trouveridskill(skillName, description, level, domain);
            System.out.println(skillId);
            
            boolean result = profileDAO.associateSkillsToProfile(profileId, skillId);
            if (!result) {
                success = false;
                break; // Sortir de la boucle dès qu'une erreur est rencontrée
            }
        }
        
        if (success) {
            request.setAttribute("message", "Les associations ont été enregistrées avec succès.");
        } else {
            request.setAttribute("message", "Une erreur s'est produite lors de l'enregistrement des associations.");
        }

        List<profile> profiles = profileDAO.getAllprofile();
        request.setAttribute("profiles", profiles);

        SkillDAO skillDAO = new SkillDAO();
        List<Skill> skills = skillDAO.getAllSkills();
        request.setAttribute("skills", skills);

        RequestDispatcher dispatcher = request.getRequestDispatcher("AssociateSkillsToProfile.jsp");
        dispatcher.forward(request, response);
    }}