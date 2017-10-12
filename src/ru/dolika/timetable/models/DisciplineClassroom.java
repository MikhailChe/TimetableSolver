package ru.dolika.timetable.models;

import java.util.concurrent.ThreadLocalRandom;

public class DisciplineClassroom {
	final long id;
	final Discipline discipline;
	final Classroom classroom;

	/**
	 * @param id
	 * @param discipline
	 * @param classroom
	 */
	public DisciplineClassroom(long id, Discipline discipline, Classroom classroom) {
		super();
		this.id = id;
		this.discipline = discipline;
		this.classroom = classroom;
	}

	public DisciplineClassroom(Discipline discipline, Classroom classroom) {
		this(ThreadLocalRandom.current().nextLong(), discipline, classroom);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DisciplineClassroom [id=" + this.id + ", "
				+ (this.discipline != null ? "discipline=" + this.discipline + ", " : "")
				+ (this.classroom != null ? "classroom=" + this.classroom : "") + "]";
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
		result = prime * result + ((this.classroom == null) ? 0 : this.classroom.hashCode());
		result = prime * result + ((this.discipline == null) ? 0 : this.discipline.hashCode());
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
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
		if (!(obj instanceof DisciplineClassroom))
			return false;
		DisciplineClassroom other = (DisciplineClassroom) obj;
		if (this.classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!this.classroom.equals(other.classroom))
			return false;
		if (this.discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!this.discipline.equals(other.discipline))
			return false;
		if (this.id != other.id)
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
	 * @return the discipline
	 */
	public final Discipline getDiscipline() {
		return this.discipline;
	}

	/**
	 * @return the classroom
	 */
	public final Classroom getClassroom() {
		return this.classroom;
	}

}
