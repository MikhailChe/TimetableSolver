package ru.dolika.timetable.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Teacher {

	@XmlElement
	private String name;
	@XmlElement
	private String middleName;
	@XmlElement
	private String lastName;

	@XmlElement
	public String getUniqueID() {
		return this.name + this.middleName + this.lastName;
	}

	@Override
	public String toString() {
		return this.lastName + " " + this.name + " " + this.middleName;
	}

	public Teacher(String name, String middleName, String lastName) {
		if (name == null || middleName == null || lastName == null)
			throw new NullPointerException("Фамилия, имя и отчество не должны быть пустыми");
		this.name = name;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o instanceof Teacher) {
			Teacher t = (Teacher) o;
			if (t.name.equals(this.name) && t.middleName.equals(this.middleName) && t.lastName.equals(this.lastName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.name + this.middleName + this.lastName).hashCode();
	}

}
