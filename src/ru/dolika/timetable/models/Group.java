package ru.dolika.timetable.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Group")
@XmlAccessorType(XmlAccessType.NONE)
public class Group {

	@XmlElement
	private int numStudents;
	@XmlElement
	private int grade;
	@XmlElement
	private char uniqueLetter;

	/**
	 * @param numStudents
	 * @param grade
	 * @param uniqueLetter
	 */
	public Group(int numStudents, int grade, char uniqueLetter) {
		super();
		this.numStudents = numStudents;
		this.grade = grade;
		this.uniqueLetter = uniqueLetter;
	}

	@Override
	public String toString() {
		return Integer.toString(this.grade) + Character.toString(this.uniqueLetter) + " (" + this.numStudents + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.grade;
		result = prime * result + this.numStudents;
		result = prime * result + this.uniqueLetter;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Group)) {
			return false;
		}
		Group other = (Group) obj;
		if (this.grade != other.grade) {
			return false;
		}
		if (this.numStudents != other.numStudents) {
			return false;
		}
		if (this.uniqueLetter != other.uniqueLetter) {
			return false;
		}
		return true;
	}
}
