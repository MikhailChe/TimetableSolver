package ru.dolika.timetable.models;

import java.util.concurrent.ThreadLocalRandom;

final public class TeacherClassroom {
	final long id;
	final Teacher teacher;
	final Classroom classroom;

	/**
	 * @param id
	 * @param teacher
	 * @param classroom
	 */
	public TeacherClassroom(final long id, final Teacher teacher, final Classroom classroom) {
		super();
		if (teacher == null || classroom == null)
			throw new NullPointerException("Учитель и кабинет не должны быть пустыми");
		this.id = id;
		this.teacher = teacher;
		this.classroom = classroom;
	}

	/**
	 * @param teacher
	 * @param classroom
	 */
	public TeacherClassroom(final Teacher teacher, final Classroom classroom) {
		this(ThreadLocalRandom.current().nextLong(), teacher, classroom);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeacherClassroom [id=" + this.id + ", " + (this.teacher != null ? "teacher=" + this.teacher + ", " : "")
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
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.teacher == null) ? 0 : this.teacher.hashCode());
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
		if (!(obj instanceof TeacherClassroom))
			return false;
		TeacherClassroom other = (TeacherClassroom) obj;
		if (this.classroom == null) {
			if (other.classroom != null)
				return false;
		} else if (!this.classroom.equals(other.classroom))
			return false;
		if (this.id != other.id)
			return false;
		if (this.teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!this.teacher.equals(other.teacher))
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
	 * @return the teacher
	 */
	public final Teacher getTeacher() {
		return this.teacher;
	}

	/**
	 * @return the classroom
	 */
	public final Classroom getClassroom() {
		return this.classroom;
	}

}
