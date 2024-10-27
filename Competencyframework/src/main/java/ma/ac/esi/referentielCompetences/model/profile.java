package ma.ac.esi.referentielCompetences.model;

public class profile {
	private String nomprofile;
	private double salaire;
	private int IdProfile;
	public String getNomprofile() {
		return nomprofile;
	}
	public void setNomprofile(String nomprofile) {
		this.nomprofile = nomprofile;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public int getIdProfile() {
		return IdProfile;
	}
	public void setIdProfile(int IdProfile) {
		this.IdProfile = IdProfile;
	}
	public profile(String nomprofile, double salaire) {
		this.nomprofile = nomprofile;
		this.salaire = salaire;
		
	}
	public profile() {}
	
	

}
