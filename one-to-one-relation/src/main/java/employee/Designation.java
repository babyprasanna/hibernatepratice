package employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Designation {

	@Id
	private int id;
	private String name;

	@OneToOne(mappedBy = "disgnation")
	private Employee empoyee;

	public Designation() {

	}

	public Designation(int id, String name, Employee empoyee) {

		this.id = id;
		this.name = name;
		this.empoyee = empoyee;
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

	public Employee getEmpoyee() {
		return empoyee;
	}

	public void setEmpoyee(Employee empoyee) {
		this.empoyee = empoyee;
	}

	@Override
	public String toString() {
		return "Disgnation [id=" + id + ", name=" + name + ", empoyee=" + empoyee + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empoyee == null) ? 0 : empoyee.hashCode());
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
		Designation other = (Designation) obj;
		if (empoyee == null) {
			if (other.empoyee != null)
				return false;
		} else if (!empoyee.equals(other.empoyee))
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
