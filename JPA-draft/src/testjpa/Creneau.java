package testjpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity 
public class Creneau {
	
	@Id
	private long id;
	@OneToOne
	private Cours  cours ;
	@ManyToOne
	private Salle salle;
	
    @ManyToOne
	private Horaire horaire;


	public Creneau() {
	}
	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	}


	public Salle getSalle() {
		return salle;
	}


public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Creneau [id=" + id + "]";
	}
	public Horaire getHoraires() {
		return horaire;
	}
	public void setHoraires(Horaire horaires) {
		this.horaire = horaires;
	}
	
	
}
