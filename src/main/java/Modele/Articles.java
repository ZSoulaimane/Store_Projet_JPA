package Modele;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="articles")
public class Articles {
	
	@Id
	private int CodeArticle;
	private String Designation;
	private int Prix;
	private int Stock;
	private String Photo;
	
	@ManyToOne
	@JoinColumn(name="Categorie", referencedColumnName = "RefCat")
	private Categories Categorie;
	
	public Articles() {
        super();
    }
	
    public Articles(int CodeArticle, String Designation, String Photo,int Prix ,int Stock) {
        super();
        this.CodeArticle = CodeArticle;
        this.Designation = Designation;
        this.Photo = Photo;
        this.Prix = Prix;
        this.Stock= Stock;
    }
	
	public int getCodeArticle() {
		return CodeArticle;
	}
	public void setCodeArticle(int codeArticle) {
		this.CodeArticle = codeArticle;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		this.Designation = designation;
	}
	public int getPrix() {
		return Prix;
	}
	public void setPrix(int prix) {
		this.Prix = prix;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		this.Stock = stock;
	}


	public String getPhoto() {
		return Photo;
	}
	public Categories getCategorie() {
		return Categorie;
	}


	public void setCategorie(Categories categs) {
		this.Categorie = categs;
	}


	public void setPhoto(String photo) {
		this.Photo = Photo;
	}
	
}
