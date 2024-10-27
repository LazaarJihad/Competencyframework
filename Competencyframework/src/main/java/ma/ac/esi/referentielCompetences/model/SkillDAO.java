package ma.ac.esi.referentielCompetences.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {
		private String url = "jdbc:mysql://localhost:3306/competency"; private String username = "root";
		private String password = "";

		private Connection getConnection() throws SQLException { 
			return DriverManager.getConnection(url, username, password);
		}

		public boolean addSkill(Skill skill) {
		String sql = "INSERT INTO Skills (name, description, domain, level,categorie) VALUES (?, ?, ?, ?,?)";
		try (
		Connection conn = getConnection(); 
		PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, skill.getName()); 
		pstmt.setString(2, skill.getDescription()); 
		pstmt.setString(3, skill.getDomain());
		pstmt.setString(4, skill.getLevel());
		pstmt.setString(5, skill.getCategorie());
		int rowAffected=pstmt.executeUpdate();
		return rowAffected >0;
		} catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Erreur lors de l'édition de la compétence : " + e.getMessage());
	        return false;
	    }
		}
		
		public List<Skill> getAllSkills() {
			 List<Skill> skills = new ArrayList<>();
			 String sql = "SELECT * FROM Skills";
			 try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement();

			 ResultSet rs = stmt.executeQuery(sql)) {
			 while (rs.next()) {
			 Skill skill = new Skill();
			 skill.setId(rs.getInt("id"));
			 skill.setName(rs.getString("name"));
			 skill.setDescription(rs.getString("description"));
			 skill.setDomain(rs.getString("domain"));
			 skill.setLevel(rs.getString("level"));
			 skill.setCategorie(rs.getString("categorie"));
			 skills.add(skill);
			 }
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }
			 return skills;
			 }
		public boolean editerSkill(Skill skill) {
		    
		    try {
		    	Connection conn = getConnection();
		        PreparedStatement pstmt = conn.prepareStatement("UPDATE Skills SET name=?, description=?, domain=?, level=?,categorie=? WHERE id=?");
		        pstmt.setString(1, skill.getName());
		        pstmt.setString(2, skill.getDescription());
		        pstmt.setString(3, skill.getDomain());
		        pstmt.setString(4, skill.getLevel());
		        pstmt.setString(5, skill.getCategorie());
		        pstmt.setInt(6, skill.getId());

		        int rowAffected = pstmt.executeUpdate();
		        return rowAffected > 0;
		          }catch (SQLException e) {
		        	  System.out.println(e.toString());
		        return false;
		    }
		}

		public boolean deleteskill(int id ) {
			try {
				Connection conn = getConnection();
				PreparedStatement delete= conn.prepareStatement("DELETE from skills where id=?");
				delete.setInt(1, id);
				int resultat = delete.executeUpdate();
				return resultat>0;
			}catch(Exception E) {
			     System.out.println(E.toString());
			     return false;
			}
		}
		public List<Skill> searchSkills(String term) {
	        List<Skill> skills = new ArrayList<>();
	        String sql = "SELECT * FROM skills WHERE name LIKE ? OR domain LIKE ? OR categorie LIKE ?";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, "%" + term + "%");
	            pstmt.setString(2, "%" + term + "%");
	            pstmt.setString(3, "%" + term + "%");

	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Skill skill = new Skill();
	                skill.setId(rs.getInt("id"));
	                skill.setName(rs.getString("name"));
	                skill.setDescription(rs.getString("description"));
	                skill.setDomain(rs.getString("domain"));
	                skill.setLevel(rs.getString("level"));
	                skill.setCategorie(rs.getString("categorie"));
	                skills.add(skill);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return skills;
	    }

		public int trouveridskill(String name,String description,String level,String domain ) {
			String sql = "SELECT id FROM skills WHERE name=? AND description=? AND level=? AND domain=? ";
			int idskill=0;
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        	pstmt.setString(1,name);
	        	pstmt.setString(2,description);
	        	pstmt.setString(3,level);
	        	pstmt.setString(4,domain);
	        	ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	idskill=rs.getInt("id");
	            }
	        	
	        }catch(Exception E){
	        	System.out.println(E.toString());
	        	System.out.println("probleme ici");
	        	
	        }
			return idskill;}
 
		
}


