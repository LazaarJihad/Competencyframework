package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import ma.ac.esi.referentielCompetences.model.Utilisateur;
import ma.ac.esi.referentielCompetences.model.UtilisateurDAO;

public class InscriptionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Utilisateur utilisateur = new Utilisateur(username, password, email);
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        utilisateurDAO.addUtilisateur(utilisateur);

        // Rediriger vers la page de connexion
        response.sendRedirect("connexion.jsp");
    }
}

