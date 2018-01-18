package testjpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cours {


	@Id
	private long id;
	@OneToOne(mappedBy="cours")
	private  Creneau creneau ;
	@ManyToMany
	private Collection<Professeur> professeurs;
	@ManyToOne
	private Matiere matiere;
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Cours() {
	}
	public long getId() {
		return id;
	}
	public Creneau getCreneau() {
		return creneau;
	}
	public void setCreneau(Creneau creneau) {
		this.creneau = creneau;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cours [id=" + id + "]";
	}
	public Collection<Professeur> getProfesseurs() {
		return professeurs;
	}
	public void setProfesseurs(Collection<Professeur> professeurs) {
		this.professeurs = professeurs;
	}



}
