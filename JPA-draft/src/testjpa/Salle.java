package testjpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Salle {
	
	@Id
	private long id;
	private  String nom;
	
	@OneToMany(mappedBy="salle")
	private Collection<Creneau> creneaux;
	public Salle() {
		
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
		return "Salle [id=" + id + ", nom=" + nom + "]";
	}



	public Collection<Creneau> getCreneaux() {
		return creneaux;
	}



	public void setCreneaux(Collection<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
	
	
	

}
