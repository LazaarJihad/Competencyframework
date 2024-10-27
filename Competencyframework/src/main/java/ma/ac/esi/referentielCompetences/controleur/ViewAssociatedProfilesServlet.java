package ma.ac.esi.referentielCompetences.controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.profile;
import ma.ac.esi.referentielCompetences.model.profileDAO;
public class ViewAssociatedProfilesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int skillId = Integer.parseInt(request.getParameter("skillId"));

        profileDAO profileDAO = new profileDAO();
        List<profile> associatedProfiles = profileDAO.getAssociatedProfiles(skillId);
        
        if (associatedProfiles.isEmpty()) {
            String errorMessage = "Aucun profil associé trouvé.";
            request.setAttribute("errorMessage", errorMessage);
        } else {
            request.setAttribute("associatedProfiles", associatedProfiles);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view_associated_profiles.jsp");
        dispatcher.forward(request, response);
    }

}
