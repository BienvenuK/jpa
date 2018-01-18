package testjpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Professeur {
	@Id
private long id;
	private String  nom;
	private String prenom;
	
	@ManyToMany(mappedBy="professeurs")
	private Collection<Cours>cours;
	
	public Professeur() {
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	public Collection<Cours> getCours() {
		return cours;
	}
	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}
	
	
}
