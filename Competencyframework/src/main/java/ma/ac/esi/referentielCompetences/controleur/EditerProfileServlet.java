package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.profile;
import ma.ac.esi.referentielCompetences.model.profileDAO;

import java.io.IOException;


public class EditerProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditerProfileServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomprofile = request.getParameter("nomprofile");
        String salaireStr = request.getParameter("salaire");
        String idProfileStr = request.getParameter("IdProfile");
        
        if (nomprofile != null && !nomprofile.isEmpty() && salaireStr != null && !salaireStr.isEmpty() && idProfileStr != null && !idProfileStr.isEmpty()) {
            try {
                int idProfile = Integer.parseInt(idProfileStr);
                double salaire = Double.parseDouble(salaireStr);
                
                profile profile = new profile(nomprofile, salaire);
                profile.setIdProfile(idProfile);

                profileDAO profileDAO = new profileDAO();
                boolean success = profileDAO.editerprofile(profile);

                if (success) {
                    response.sendRedirect("ProfileServlet");
                } else {
                    response.getWriter().println("Échec de l'édition du profil.");
                }
            } catch (NumberFormatException e) {
                response.getWriter().println("Erreur de conversion de paramètre.");
            }
        } else {
            response.getWriter().println("Paramètres manquants.");
        }
    }
}
