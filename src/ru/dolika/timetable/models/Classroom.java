package ru.dolika.timetable.models;

import java.util.concurrent.ThreadLocalRandom;

public class Classroom {
	final long id;
	final String name;
	final int classesAllowed;
	final int numStudentsAllowed;

	/**
	 * @param id
	 * @param name
	 * @param classesAllowed
	 * @param numStudentsAllowed
	 */
	public Classroom(final long id, final String name, final int classesAllowed, final int numStudentsAllowed) {
		super();
		if (name == null)
			throw new NullPointerException("У класса должно быть название.");
		this.id = id;
		this.name = name;
		this.classesAllowed = classesAllowed;
		this.numStudentsAllowed = numStudentsAllowed;
	}

	public Classroom(final String name) {
		this(ThreadLocalRandom.current().nextLong(), name, -1, -1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classroom [id=" + this.id + ", " + (this.name != null ? "name=" + this.name + ", " : "")
				+ "classesAllowed=" + this.classesAllowed + ", numStudentsAllowed=" + this.numStudentsAllowed + "]";
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
		result = prime * result + this.classesAllowed;
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + this.numStudentsAllowed;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Classroom))
			return false;
		Classroom other = (Classroom) obj;
		if (this.classesAllowed != other.classesAllowed)
			return false;
		if (this.id != other.id)
			return false;
		if (!this.name.equals(other.name))
			return false;
		if (this.numStudentsAllowed != other.numStudentsAllowed)
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public final long getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * @return the classesAllowed
	 */
	public final int getClassesAllowed() {
		return this.classesAllowed;
	}

	/**
	 * @return the numStudentsAllowed
	 */
	public final int getNumStudentsAllowed() {
		return this.numStudentsAllowed;
	}

}
