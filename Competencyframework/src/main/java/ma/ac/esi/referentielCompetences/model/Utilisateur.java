package ma.ac.esi.referentielCompetences.model;

public class Utilisateur {
	private int IdUtilisateur;
	private String username;
    private String password;
    private String email;
    private int TypeUtilisateur=1;
    

    public int getTypeUtilisateur() {
		return TypeUtilisateur;
	}
	public void setTypeUtilisateur(int TypeUtilisateur) {
		this.TypeUtilisateur = TypeUtilisateur;
	}
	public Utilisateur(String username, String password, String email,int TypeUtilisateur) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.TypeUtilisateur=TypeUtilisateur;
        
    }
	
    public Utilisateur(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Utilisateur () {};

	public String getUsername() {
		return username;
	}

	public int getIdUtilisateur() {
		return IdUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		IdUtilisateur = idUtilisateur;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    

}
