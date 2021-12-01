package student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollnum;
	private String name;

	@OneToOne
	private Laptop laptop;

	public Student() {

	}

	public Student(int rollnum, String name, Laptop laptop) {

		this.rollnum = rollnum;
		this.name = name;
		this.laptop = laptop;
	}

	public int getRollnum() {
		return rollnum;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollnum=" + rollnum + ", name=" + name + ", laptop=" + laptop + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((laptop == null) ? 0 : laptop.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollnum;
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
		Student other = (Student) obj;
		if (laptop == null) {
			if (other.laptop != null)
				return false;
		} else if (!laptop.equals(other.laptop))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rollnum != other.rollnum)
			return false;
		return true;
	}

}
