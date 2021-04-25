package Modele;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Clients {
	
	@Id
	private int id;
	
	private String Email;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private int CodePostal;
	private String Ville;
	private int Tel;
	private String MotPasse;
	
	@OneToMany
	@JoinColumn(name="CodeClient", referencedColumnName ="Id")
	private List<Commandes> commands;
	
	public Clients(int id, String email, String nom, String prenom, String adresse, int codePostal, String ville,
			int tel, String motPasse) {
		super();
		this.id = id;
		Email = email;
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		CodePostal = codePostal;
		Ville = ville;
		Tel = tel;
		MotPasse = motPasse;
	}
	
	
	
	public Clients() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public int getCodePostal() {
		return CodePostal;
	}
	public void setCodePostal(int codePostal) {
		CodePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}
	public String getMotPasse() {
		return MotPasse;
	}
	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
	
	
	
}
