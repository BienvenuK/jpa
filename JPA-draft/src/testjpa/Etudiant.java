package testjpa;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Etudiant{


	@Id
	private String numeroEtudiant;
	private String nom;
	private String prenom;
	
	@ManyToOne
	private Cursus cursus;
	
	public Etudiant(){
		
	}

	public String getNumeroEtudiant() {
		return numeroEtudiant;
	}
	public void setNumeroEtudiant(String numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
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
	
	@Override
	public String toString() {
		return "Etudiant [numeroEtudiant=" + numeroEtudiant + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}





}
