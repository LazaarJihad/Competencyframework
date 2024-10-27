package ma.ac.esi.referentielCompetences.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ma.ac.esi.referentielCompetences.model.profile;

public class profileDAO {
		private String url = "jdbc:mysql://localhost:3306/competency"; private String username = "root";
		private String password = "";

		private Connection getConnection() throws SQLException { 
			return DriverManager.getConnection(url, username, password);
		}

		public boolean addprofile(profile profile) {
		String sql = "INSERT INTO profile (nomprofile, salaire) VALUES (?, ?)";
		try (
		Connection conn = getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, profile.getNomprofile()); 
		pstmt.setDouble(2, profile.getSalaire()); 
		int rowAffected=pstmt.executeUpdate();
		return rowAffected >0;
		} catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Erreur lors de l'édition de la compétence : " + e.getMessage());
	        return false;
	    }
		}
		
		public List<profile> getAllprofile() {
			 List<profile> profiles= new ArrayList<>();
			 String sql = "SELECT * FROM profile";
			 try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement();

			 ResultSet rs = stmt.executeQuery(sql)) {
			 while (rs.next()) {
			 profile profile = new profile();
			 profile.setIdProfile(rs.getInt("IdProfile"));
			 System.out.println( rs.getInt("IdProfile"));
			 System.out.println( profile.getIdProfile());
			 profile.setNomprofile(rs.getString("nomprofile"));
			 profile.setSalaire(rs.getDouble("salaire"));
			 profiles.add(profile);
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return profiles;
			 }
		public boolean editerprofile(profile profile) {
		    
		    try {
		    	Connection conn = getConnection();
		        PreparedStatement pstmt = conn.prepareStatement("UPDATE profile SET nomprofile=?,salaire=?WHERE IdProfile=?");
		        pstmt.setString(1, profile.getNomprofile());
		        pstmt.setDouble(2, profile.getSalaire());
		        pstmt.setInt(3, profile.getIdProfile());
		        int rowAffected = pstmt.executeUpdate();
		        return rowAffected > 0;
		          }catch (SQLException e) {
		        	  System.out.println(e.toString());
		        return false;
		    }
		}

		public boolean deleteprofile(int IdProfile ) {
			try {
				Connection conn = getConnection();
				PreparedStatement delete= conn.prepareStatement("DELETE from profile where IdProfile=?");
				delete.setInt(1, IdProfile);
				int resultat = delete.executeUpdate();
				return resultat>0;
			}catch(Exception E) {
			     System.out.println(E.toString());
			     return false;
			}
		}
		
		
		
		public List<profile> searchprofile(String term) {
	        List<profile> profiles = new ArrayList<>();
	        String sql = "SELECT * FROM profile WHERE nomprofile LIKE ? OR salaire LIKE ? ";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, "%" + term + "%");
	            pstmt.setString(2, "%" + term + "%");

	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                profile profile = new profile();
	                profile.setIdProfile(rs.getInt("IdProfile"));
	                profile.setNomprofile(rs.getString("nomprofile"));
	                profile.setSalaire(rs.getDouble("salaire"));
	                profiles.add(profile);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return profiles;
	    }
		
		public boolean associateSkillsToProfile(int profileId, int idskill) {
	        String sql = "INSERT INTO competenceprofile (idprofile, idcompetence) VALUES (?, ?)";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	                pstmt.setInt(1, profileId);
	                pstmt.setInt(2, idskill);
	                int rowAffected=pstmt.executeUpdate();
	        		return rowAffected >0;
	        		} catch (SQLException e) {
	        	        e.printStackTrace();
	        	        System.err.println("Erreur lors de : " + e.getMessage());
	        	        return false;
	        	    }
	        		}
 
		public int trouveridprofile(String nomprofile,double salaire ) {
			String sql = "SELECT IdProfile FROM profile WHERE nomprofile=? AND salaire=? ";
			int IdProfile=0;
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1,nomprofile);
	        	pstmt.setDouble(2, salaire);
	        	ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	
	            	IdProfile=rs.getInt("IdProfile");
	            }
	        	
	        }catch(Exception E){
	        	System.out.println(E.toString());
	        }
			return IdProfile;
		}

		public int selectionnerprofile(int id) {
			String sql = "SELECT idprofile FROM  competenceprofile WHERE idcompetence=? ";
			int idprofile=0 ;
			try (
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				
				ResultSet resultat= pstmt.executeQuery();
				if(resultat.next()) {
					idprofile=resultat.getInt("idprofile");
				}
				
			}
			catch(Exception E ) {
				E.printStackTrace();
					
			}
			return idprofile;
		}
			
		public profile detailprofile(int id) {
			String sql = "SELECT * FROM  profile WHERE IdProfile=? ";
			profile profile = new profile();
			try (
		   
			Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setInt(1, id);
				
				ResultSet resultat= pstmt.executeQuery();
				if(resultat.next()) {
					profile.setNomprofile(resultat.getNString("nomprofile"));
					profile.setSalaire(resultat.getDouble("salaire"));
				}
				
			}
			catch(Exception E ) {
				E.printStackTrace();
					
			}
			return profile;
		}

		public List<profile> getAssociatedProfiles(int skillId) {
		    List<profile> associatedProfiles = new ArrayList<>();
		    String sql = "SELECT p.* FROM profile p INNER JOIN competenceprofile cp ON p.IdProfile = cp.idprofile WHERE cp.idcompetence = ?";
		    try (Connection conn = getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setInt(1, skillId);
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		            profile profile = new profile();
		            profile.setIdProfile(rs.getInt("IdProfile"));
		            profile.setNomprofile(rs.getString("nomprofile"));
		            profile.setSalaire(rs.getDouble("salaire"));
		            associatedProfiles.add(profile);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return associatedProfiles;
		}


}


