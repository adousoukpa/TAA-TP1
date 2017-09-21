package master2.tp1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sport {

	
	long id;
	
	
	List<Person> persons = new ArrayList<Person>();
	
	@ManyToMany
	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}

	List<Lieu> lieux = new ArrayList<Lieu>();
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void setId(long id) {
		this.id = id;
	}

	String name;
	
	int niveau;

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	@ManyToMany(mappedBy="sports")
	public List<Person> getPersons (){
		return persons;
	}
	
	public void addLieu(Lieu lieu) {
		if (!this.lieux.contains(lieu)) {
			this.lieux.add(lieu);
		}
	}
	
	public void removeLieu(Lieu lieu) {
		this.lieux.remove(lieu);
	}
	
	public void addPerson(Person person) {
		if (!this.persons.contains(person)) {
			this.persons.add(person);
		}
	}
	
	public void removePerson(Person person) {
		this.persons.remove(person);
	}
}
