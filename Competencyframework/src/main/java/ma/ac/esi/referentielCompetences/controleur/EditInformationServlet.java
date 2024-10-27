package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ma.ac.esi.referentielCompetences.model.UtilisateurDAO;

import ma.ac.esi.referentielCompetences.model.Utilisateur;
/**
 * Servlet implementation class EditInformationServlet
 */
public class EditInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldUsername = request.getParameter("oldUsername");
        String oldPassword = request.getParameter("oldPassword");
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("newEmail");
        System.out.println(oldUsername);
        System.out.println(oldPassword);
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        int userId = utilisateurDAO.getUserId(oldUsername, oldPassword);
        System.out.println(userId);

        if (userId >= 0) {
            
            Utilisateur user = new Utilisateur();
            user.setIdUtilisateur(userId);
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            user.setEmail(newEmail);

            System.out.println(user.getIdUtilisateur());
            System.out.println(user.getPassword());

            boolean updated = utilisateurDAO.editerUtilisateur(user);

            if (updated) {
                response.sendRedirect("editerinformation.jsp?success=ProfileUpdated");
            } else {
                response.sendRedirect("editerinformation.jsp?error=UpdateFailed");
            }
        } 
    }


}
