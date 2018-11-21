package fr.ngando.person.domain;

public class Person {
	
	private int id;
	private String civilite;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String email;
	private String password;
	private String telephone;
	private String numeroEtRue;
	private String ville;
	private String departement;
	private String pays;
	private String grant;
	
	
	public Person(String civilite, String nom, String prenom, String dateNaissance, String email, String password, String telephone, String numeroEtRue, String ville, String departement, String pays) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.numeroEtRue = numeroEtRue;
		this.ville = ville;
		this.departement = departement;
		this.pays = pays;
	}
	
	public Person(int id, String civilite, String nom, String prenom, String dateNaissance, String email,
			String password, String telephone, String numeroEtRue, String ville, String departement, String pays) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.numeroEtRue = numeroEtRue;
		this.ville = ville;
		this.departement = departement;
		this.pays = pays;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		/*String[] splitDateNaissance = dateNaissance.split("-");
		if(splitDateNaissance.length != 0) {
			return splitDateNaissance[2]+"/"+splitDateNaissance[1]+"/"+splitDateNaissance[0];
		}*/
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNumeroEtRue() {
		return numeroEtRue;
	}

	public void setNumeroEtRue(String numeroEtRue) {
		this.numeroEtRue = numeroEtRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrant() {
		return grant;
	}

	public void setGrant(String grant) {
		this.grant = grant;
	}
		
}
