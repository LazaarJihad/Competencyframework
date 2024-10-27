package ma.ac.esi.referentielCompetences.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class User {
      private String login;
      private String password;
	public User(String login,String password) {
		this.login=login;
		this.password=password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String url = "jdbc:mysql://localhost:3306/competency"; private String username = "root";
	private String Password = "";

	private Connection getConnection() throws SQLException { 
		return DriverManager.getConnection(url, username, Password);
	}
	
	
      
}
