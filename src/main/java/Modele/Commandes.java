package Modele;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="commandes")
public class Commandes {

	@Id
	@Column(name="NumCommande")
	private int NumCommande;
	
	@Column(name="DateCommande")
	private String DateCommande;
	
	@ManyToOne
	@JoinColumn(name="CodeClient", referencedColumnName = "Id")
	private Clients client;
	
//	@OneToMany
//	@JoinColumn(name="NumCommande", referencedColumnName ="NumCommande")
//	private List<Lignescommandes> cmds;
	
	public Commandes(int numCommande,Clients client, String dateCommande) {
		super();
		this.NumCommande = numCommande;
		this.client = client;
		this.DateCommande = dateCommande;
	}
	
	public Commandes(Clients client, String dateCommande) {
		super();
		this.client = client;
		this.DateCommande = dateCommande;
	}

	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

	public Commandes() {
		super();
	}

	public int getNumCommande() {
		return NumCommande;
	}
	public void setNumCommande(int numCommande) {
		NumCommande = numCommande;
	}

	public String getDateCommande() {
		return DateCommande;
	}
	public void setDateCommande(String dateCommande) {
		DateCommande = dateCommande;
	}
	
}
