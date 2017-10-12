package ru.dolika.timetable.models;

public class DisciplineGroup {
	final long id;
	final Group group;
	final Discipline discipline;

	/**
	 * @param id
	 * @param teacher
	 * @param discipline
	 */
	public DisciplineGroup(long id, Group group, Discipline discipline) {
		super();
		this.id = id;
		this.group = group;
		this.discipline = discipline;
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
	public final Group getGroup() {
		return this.group;
	}

	/**
	 * @return the discipline
	 */
	public final Discipline getDiscipline() {
		return this.discipline;
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
		result = prime * result + ((this.discipline == null) ? 0 : this.discipline.hashCode());
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.group == null) ? 0 : this.group.hashCode());
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
		if (!(obj instanceof DisciplineGroup)) {
			return false;
		}
		DisciplineGroup other = (DisciplineGroup) obj;
		if (this.discipline == null) {
			if (other.discipline != null) {
				return false;
			}
		} else if (!this.discipline.equals(other.discipline)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.group == null) {
			if (other.group != null) {
				return false;
			}
		} else if (!this.group.equals(other.group)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DisciplineGroup [id=" + this.id + ", " + (this.group != null ? "group=" + this.group + ", " : "")
				+ (this.discipline != null ? "discipline=" + this.discipline : "") + "]";
	}
}
