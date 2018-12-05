package org.personal.rampup.fundamentals;

import java.util.Date;

public class ImmutableEx1 {

	public static void main(String[] args) {
		ImmutableClass immutableClass1 = new ImmutableClass(10, "sanjay", new Date());
		System.out.println(immutableClass1.toString() + " HASH Code: " + immutableClass1.hashCode());
		immutableClass1.getDateOfBirth().setYear(2019);
		System.out.println(immutableClass1.toString() + " HASH Code: " + immutableClass1.hashCode());

	}

}

final class ImmutableClass{
	
	private int id;
	
	private String name;
	
	private final Date dateOfBirth;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfBirth() {
		Date toReturn = new Date();
		toReturn.setDate(dateOfBirth.getDate());
		return toReturn;
	}

	public ImmutableClass(int id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		Date newDateOfBirth = new Date();
		newDateOfBirth.setDate(dateOfBirth.getDate());
		this.dateOfBirth=newDateOfBirth;
	}

	@Override
	public String toString() {
		return "ImmutableClass [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
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
		ImmutableClass other = (ImmutableClass) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
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
	*/
	
	
	/*ImmutableClass [id=10, name=sanjay, dateOfBirth=Thu Nov 08 23:30:54 IST 2018] HASH Code: 865113938
	ImmutableClass [id=10, name=sanjay, dateOfBirth=Sat Nov 08 23:30:54 IST 3919] HASH Code: 865113938*/
	
	
	
	
}
