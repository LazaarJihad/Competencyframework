package ma.ac.esi.referentielCompetences.model;

public class Skill {
	    private int Id;
	    private String name ;
	    private String description;
	    private String domain;
	    private String level;
	    private String categorie;
		public Skill(String name ,String description ,String domain,String level , String categorie ) {
			this.name= name;
			this.description=description;
			this.domain=domain;
			this.level=level;
			this.categorie=categorie;
		}
		public Skill() {}
		public String getName() {
			return name;
		}
		
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getLevel() {
			return level;
		}
		public void setLevel(String level) {
			this.level = level;
		}
		
		public String getCategorie() {
			return categorie;
		}
		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}
		@Override
		public String toString() {
			return "Skill [name=" + name + ", description=" + description + ", domain=" + domain +", categorie=" + categorie+ ", level=" + level
					+ " ]";
		}
	    
	    
}
