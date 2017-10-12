package ru.dolika.timetable.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Discipline {

	@XmlElement
	private String name;
	@XmlElement
	private long score;
	@XmlElement
	private int subdivisionFactor;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Discipline [" + (this.name != null ? "name=" + this.name + ", " : "") + "score=" + this.score
				+ ", subdivisionFactor=" + this.subdivisionFactor + "]";
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
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
		if (!(obj instanceof Discipline)) {
			return false;
		}
		Discipline other = (Discipline) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * @param name
	 */
	public Discipline(String name) {
		this(name, 1, 1);
	}

	/**
	 * @param score
	 * @param name
	 * @param subdivision
	 */
	public Discipline(String name, long score, int subdivision) {
		super();
		if (name == null)
			throw new NullPointerException("Название дисциплины не должно быть пустым");
		this.score = score;
		this.name = name;
		this.subdivisionFactor = subdivision;
	}
}
