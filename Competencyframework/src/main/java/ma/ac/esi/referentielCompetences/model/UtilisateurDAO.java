package ma.ac.esi.referentielCompetences.model;

import java.sql.*;


public class UtilisateurDAO {
	private String url = "jdbc:mysql://localhost:3306/competency"; private String username = "root";
	private String password = "";

	private Connection getConnection() throws SQLException { 
		return DriverManager.getConnection(url, username, password);
	}
	public boolean addUtilisateur(Utilisateur utilisateur) {
		String sql = "INSERT INTO utilisateur (username, password, email) VALUES (?, ?, ?)";
		try (
		Connection conn = getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, utilisateur.getUsername()); 
		pstmt.setString(2, utilisateur.getPassword()); 
		pstmt.setString(3, utilisateur.getEmail());
	 
		int rowAffected=pstmt.executeUpdate();
		return rowAffected >0;
		} catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Erreur lors de l'ajoue de l'utilisateur  : " + e.getMessage());
	        return false;
	    }
		}
	public int verifierutilisateur(String username,String password) {
		String sql = "SELECT * FROM  utilisateur WHERE username=? AND password=?";
		int typeutilisateur=0 ;
		try (
		Connection conn = getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			ResultSet resultat= pstmt.executeQuery();
			if(resultat.next()) {
				typeutilisateur=resultat.getInt("TypeUtilisateur");
			}
			
		}
		catch(Exception E ) {
			E.printStackTrace();
				
		}
		return typeutilisateur;
	}
	
	public boolean editerUtilisateur(Utilisateur utilisateur) {
	    
	    try {
	    	Connection conn = getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("UPDATE utilisateur SET username=?, password=?, email=? WHERE IdUtilisateur=?");
	        pstmt.setString(1, utilisateur.getUsername());
	        pstmt.setString(2, utilisateur.getPassword());
	        pstmt.setString(3, utilisateur.getEmail());
	        pstmt.setInt(4, utilisateur.getIdUtilisateur());
	        int rowAffected = pstmt.executeUpdate();
	        return rowAffected > 0;
	          }catch (SQLException e) {
	        	  System.out.println(e.toString());
	        return false;
	    }
	}
	
	public int getUserId(String username,String password) {
		String sql = "SELECT IdUtilisateur FROM  utilisateur WHERE username=? AND password=?";
		int id=0 ;
		try (
		Connection conn = getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			ResultSet resultat= pstmt.executeQuery();
			if(resultat.next()) {
				id=resultat.getInt("IdUtilisateur");
			}
			
		}
		catch(Exception E ) {
			E.printStackTrace();
				
		}
		return id ;
	}
	
	
	
}
