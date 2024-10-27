package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import ma.ac.esi.referentielCompetences.model.profile;
import ma.ac.esi.referentielCompetences.model.profileDAO;

import java.io.IOException;
import java.util.List;

public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method of profileServlet is called.");
        profileDAO profileDAO = new profileDAO(); 
        List<profile> profiles = profileDAO.getAllprofile();
       
        request.setAttribute("items", profiles);
        
        // Redirection vers la page SkillCrud.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profileCrud.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nomprofile = request.getParameter("nomprofile");
        String salirestr = request.getParameter("salaire");
        double salaire = Double.parseDouble(salirestr);
        
        profileDAO profileDAO = new profileDAO();
        profile profile = new profile(nomprofile, salaire);

        boolean success = profileDAO.addprofile(profile);
        
        if (success) {
            
            request.setAttribute("message", "La compétence a été ajoutée avec succès.");
        } else {
            request.setAttribute("erreur", "Erreur lors de l'ajout de la compétence.");
        }
        
        List<profile> profiles = profileDAO.getAllprofile();
        request.setAttribute("items", profiles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/profileCrud.jsp");
        dispatcher.forward(request, response);
    }
}
