package ru.dolika.timetable.models;

public final class TeacherDiscipline {
	final long id;
	final Teacher teacher;
	final Discipline discipline;

	public TeacherDiscipline(final long id, final Teacher t, final Discipline d) {
		if (t == null || d == null)
			throw new NullPointerException("Учитель и дисциплина не должны быть пустыми");
		this.id = id;
		this.teacher = t;
		this.discipline = d;
	}

	@Override
	protected TeacherDiscipline clone() {
		return new TeacherDiscipline(this.id, this.teacher, this.discipline);
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
		if (!(obj instanceof TeacherDiscipline)) {
			return false;
		}
		TeacherDiscipline other = (TeacherDiscipline) obj;
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
		if (this.teacher == null) {
			if (other.teacher != null) {
				return false;
			}
		} else if (!this.teacher.equals(other.teacher)) {
			return false;
		}
		return true;
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
		result = prime * result + ((this.teacher == null) ? 0 : this.teacher.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeacherDiscipline [id=" + this.id + ", "
				+ (this.teacher != null ? "teacher=" + this.teacher + ", " : "")
				+ (this.discipline != null ? "discipline=" + this.discipline : "") + "]";
	}

}
