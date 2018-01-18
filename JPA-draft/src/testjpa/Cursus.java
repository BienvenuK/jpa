package testjpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cursus {
	
	@Id
	private long id ;
	private String nom;
	
	
	@OneToMany(mappedBy="cursus")
	private Collection<Etudiant>etudiants;
	
	@ManyToMany
	private Collection<Matiere> matieres;
	
	
	
	
	
	public Collection<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Cursus() {
	
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
	@Override
	public String toString() {
		return "Cursus [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	

}
