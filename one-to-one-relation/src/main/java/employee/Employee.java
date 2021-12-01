package employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	private int id;
	private String name;

	@OneToOne
	private Designation disgnation;

	public Employee() {

	}

	public Employee(int id, String name, Designation disgnation) {
		
		this.id = id;
		this.name = name;
		this.disgnation = disgnation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Designation getDisgnation() {
		return disgnation;
	}

	public void setDisgnation(Designation disgnation) {
		this.disgnation = disgnation;
	}

	@Override
	public String toString() {
		return "Empoyee [id=" + id + ", name=" + name + ", disgnation=" + disgnation + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disgnation == null) ? 0 : disgnation.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (disgnation == null) {
			if (other.disgnation != null)
				return false;
		} else if (!disgnation.equals(other.disgnation))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
