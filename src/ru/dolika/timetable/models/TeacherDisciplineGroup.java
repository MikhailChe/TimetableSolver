package ru.dolika.timetable.models;

public class TeacherDisciplineGroup {
	final long id;
	final TeacherDiscipline teacherDiscipline;
	final Group group;

	/**
	 * @param id
	 * @param teacherDiscipline
	 * @param group
	 */
	public TeacherDisciplineGroup(long id, TeacherDiscipline teacherDiscipline, Group group) {
		super();
		this.id = id;
		this.teacherDiscipline = teacherDiscipline;
		this.group = group;
	}

	public TeacherDisciplineGroup(TeacherDiscipline teacherDiscipline, Group group) {
		this(0, teacherDiscipline, group);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeacherDisciplineGroup [id=" + this.id + ", "
				+ (this.teacherDiscipline != null ? "teacherDiscipline=" + this.teacherDiscipline + ", " : "")
				+ (this.group != null ? "group=" + this.group : "") + "]";
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
		result = prime * result + ((this.group == null) ? 0 : this.group.hashCode());
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.teacherDiscipline == null) ? 0 : this.teacherDiscipline.hashCode());
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
		if (!(obj instanceof TeacherDisciplineGroup))
			return false;
		TeacherDisciplineGroup other = (TeacherDisciplineGroup) obj;
		if (this.group == null) {
			if (other.group != null)
				return false;
		} else if (!this.group.equals(other.group))
			return false;
		if (this.id != other.id)
			return false;
		if (this.teacherDiscipline == null) {
			if (other.teacherDiscipline != null)
				return false;
		} else if (!this.teacherDiscipline.equals(other.teacherDiscipline))
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
	 * @return the teacherDiscipline
	 */
	public final TeacherDiscipline getTeacherDiscipline() {
		return this.teacherDiscipline;
	}

	/**
	 * @return the group
	 */
	public final Group getGroup() {
		return this.group;
	}

}
