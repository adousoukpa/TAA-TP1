package master2.tp1.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lieu {

	long id;
	String name;
	
	List<Person> persons = new ArrayList<Person>();
	
	List<Sport> sports = new ArrayList<Sport>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(mappedBy="lieux")
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@ManyToMany(mappedBy="lieux")
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void addSport(Sport sport) {
		if (!this.sports.contains(sport)) {
			this.sports.add(sport);
		}
	}
	
	public void removeSport(Sport sport) {
		this.sports.remove(sport);
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
