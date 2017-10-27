package ru.dolika.timetable.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson {
	final Group group;
	final Discipline discipline;
	final Set<Teacher> teachers;

	/**
	 * @param group
	 * @param discipline
	 * @param teachers
	 */
	public Lesson(Group group, Discipline discipline, Set<Teacher> teachers) {
		super();
		if (group == null || discipline == null || teachers == null)
			throw new NullPointerException("Группа, дисциплина и учитель не должны быть пустыми");
		this.group = group;
		this.discipline = discipline;
		this.teachers = teachers;
	}

	public Lesson(Group group, Discipline discipline, Teacher... teachers) {
		super();
		if (group == null || discipline == null || teachers.length == 0)
			throw new NullPointerException("Группа, дисциплина и учитель не должны быть пустыми");
		this.group = group;
		this.discipline = discipline;
		this.teachers = new HashSet<>();
		this.teachers.addAll(Arrays.asList(teachers));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lesson [" + "group=" + this.group + ", " + "discipline=" + this.discipline + ", " + "teachers="
				+ this.teachers + "]";
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
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((teachers == null) ? 0 : teachers.hashCode());
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
		if (!(obj instanceof Lesson))
			return false;
		Lesson other = (Lesson) obj;
		if (!this.discipline.equals(other.discipline))
			return false;
		if (!this.group.equals(other.group))
			return false;
		if (!this.teachers.equals(other.teachers))
			return false;
		return true;
	}

	/**
	 * @return the group
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

	/**
	 * @return the teachers
	 */
	public final Set<Teacher> getTeachers() {
		return this.teachers;
	}

}
