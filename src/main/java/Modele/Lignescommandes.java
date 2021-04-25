package Modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="lignecommandes")
public class Lignescommandes implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="NumCommande", referencedColumnName = "NumCommande")
	private Commandes coms;
	
	@Id
	@ManyToOne
	@JoinColumn(name="CodeArticle", referencedColumnName = "CodeArticle")
	private Articles articles;
	
	private int QteCde;
	
		
	public Lignescommandes(Commandes numCommande, Articles codeArticle, int qteCde) {
		super();
		this.coms = numCommande;
		this.articles = codeArticle;
		this.QteCde = qteCde;
	}
	
	public Lignescommandes() {
		super();
	}


	public Commandes getComs() {
		return coms;
	}

	public void setComs(Commandes coms) {
		this.coms = coms;
	}

	public Articles getArticles() {
		return articles;
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	public int getQteCde() {
		return QteCde;
	}
	public void setQteCde(int qteCde) {
		QteCde = qteCde;
	}
	
}
