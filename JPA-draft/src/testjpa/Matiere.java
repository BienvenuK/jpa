package testjpa;


import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Matiere {
	
	@Id
	private int id ;
	private String nom;
	@ManyToMany(mappedBy="matieres")
	private Collection<Cursus>cursus;
	
	@OneToMany(mappedBy="matiere")
	private Collection<Cours> cours;
	

	
	public Collection<Cursus> getCursus() {
		return cursus;
	}
	public void setCursus(Collection<Cursus> cursus) {
		this.cursus = cursus;
	}
	public Matiere() {
		
	}
	public int getId() {
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
		return "Matiere [id=" + id + ", nom=" + nom + ", cursus=" + cursus + ", cours=" + cours + "]";
	}
	public Collection<Cours> getCours() {
		return cours;
	}
	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}
	
	

}
