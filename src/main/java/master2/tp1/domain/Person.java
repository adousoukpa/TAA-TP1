package master2.tp1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	
	long id;
	
	String name;
	String firstname;
    private List<Sport> sports = new ArrayList<Sport>();
	List<Lieu> lieux = new ArrayList<Lieu>();

	@ManyToMany
	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToMany
	public List<Sport> getSports() {
		return sports;
	}
	
	public void addLieu(Lieu lieu) {
		if (!this.lieux.contains(lieu)) {
			this.lieux.add(lieu);
		}
	}
	
	public void removeLieu(Lieu lieu) {
		this.lieux.remove(lieu);
	}
	
	public void addSport(Sport sport) {
		if (!this.sports.contains(sport)) {
			this.sports.add(sport);
		}
	}
	
	public void removeSport(Sport sport) {
		this.sports.remove(sport);
	}
	
}
