package testjpa;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Horaire {
	
	
	
	
	@Id
	private long  id ;
	private Timestamp debut ;
	private Timestamp fin;
	
	@OneToMany(mappedBy="horaire")
	private Collection<Creneau>creneaux;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDebut() {
		return debut;
	}
	public void setDebut(Timestamp debut) {
		this.debut = debut;
	}
	public Timestamp getFin() {
		return fin;
	}
	public void setFin(Timestamp fin) {
		this.fin = fin;
	}
	public Collection<Creneau> getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(Collection<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
	@Override
	public String toString() {
		return "Horaire [id=" + id + ", debut=" + debut + ", fin=" + "]";
	}
	
	

}
