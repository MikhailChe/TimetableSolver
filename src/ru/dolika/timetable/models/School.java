package ru.dolika.timetable.models;

import java.util.Set;

public class School {

	// Рабочие примитивы
	Set<Teacher> teachers;
	Set<Classroom> classrooms;
	Set<Discipline> disciplines;
	Set<Group> groups;

	// Учитель-дисциплина
	// данный список нужен для того, чтобы знать какой учитель может вести
	// дисциплину
	// Если учителя нет в данном списке - его не будет в расписании (жёсткая связь)
	Set<TeacherDiscipline> teacherDisciplines;

	// Дисциплина-группа
	// Набор данных для понимания какая дисциплина у какой группы в этом семестре
	// (четверти)
	// Если группы нет в списке - она не попадает в расписание
	Set<DisciplineGroup> disciplineGroups;

	// Набор учитель-дисциплина-группа.
	// Необходим, чтобы понять какой именно учитель должен вести у группы занятия по
	// опеределённой дисцилине
	// Если связи нет - выбириается случайный учитель (наименее занятый)
	// Если связь есть - выбирается тот учитель, который есть в связи
	// Если в связи несколько учителей на одну дисциплину, то выбирается то
	// количетво учителей, которое необходимо для данной дисциплины. Например, если
	// у нас есть дисциплина иностранный язык и иностранных языков может быть два,
	// то будут выбраны два учителя. Если при этом учитель один, то будет выбран
	// один учитель на два языка. Если язык один, а учителей несколько, то будет
	// выбран учитель в соответствии с занятостью
	// Для начала нагрузка распределяется согласно чётким правилам, а затем
	// дополняется.
	Set<TeacherDisciplineGroup> teacherDisciplineGroups;

	// Учитель-комната.
	// Данный список нужен для того чтобы определять какого преподавателя в какую
	// аудиторию можно ставить
	// Существет два списка чёрный и белый. Если преподаватель не находится ни в
	// одном из них - применяется общее правило о том, что он может находиться в
	// любой аудитории
	// Если преподаватель находится в чёрном списке аудитории, то тогда в эту
	// аудиторию его занятия ставиться будут только в особых случаях
	// Если преподаватель находится в белом списке аудитории, то тогда все занятию
	// будут ставиться только в эту аудиторию (за исключением особых случаев)
	// По сути является мягко задающей функцией (функция с баллами) +100 если белый
	// список, -100 если чёрный
	// Даёт гибкость (например, если все аудитории заняты, то алгоритм при
	// необходимости поставит в свободную аудиторию, даже если она будет в чёрном
	// списке)
	// Является задающим для списка "учитель-дисциплина-комната"
	Set<TeacherClassroom> teacherClassroomWhite;
	Set<TeacherClassroom> teacherClassroomBlack;

	// TODO: Поменять концепцию с черных-белых списков на систему с баллами
	// Дисципина-комната.
	// Данный список нужен для того, чтобы определять какую дисциплину в какой
	// аудитории нужно вести.
	// Существует два списка - чёрный и белый
	// Если аудитория попадает в чёрный список для дисциплины - в ней нельзя
	// проводить занятия (кроме крайних случаев)
	// Если аудитория попадает в белый список для дисциплины - алгоритм старается
	// поместить дисциплину именно в эту аудиторию (кроме крайних случаев)
	Set<DisciplineClassroom> disciplineClassroomWhite;
	Set<DisciplineClassroom> disciplineClassroomBlack;

	// Набор неподразделённых уроков. Каждый урок содержит информацию о группе,
	// дисциплине и учителе (учителях, если дисциплина подразделяется, как например
	// иностранные языки)
	// Информация о разделении уроков на подуроки и подгруппы должна содержаться в
	// MetaLessons
	// TODO: написать класс MetaLessons, который должен будет содержать информацию о
	// начальном уроке (Lesson), а также подразделять группы на подгруппы с
	// возможностью временного разделения и проверки занятости. подгруппы должны
	// подразделяться таким образом, чтобы можно было их идентифицировать и нельзя
	// было случайно поставить одну и ту же подгруппу в одно и то же время на разные
	// уроки. Более того MetaLesson должен понимать разницу между группами,
	// разделёнными на разное количество частей. Например, если для одного урока
	// группа разделена на три части, а для другого на 2, то нельзя ставит в одно и
	// то же время два таких урока, так как ученики из трети могут оказаться
	// учениками из пловинки
	Set<Lesson> lessons;

	/**
	 * @return the teachers
	 */
	public final Set<Teacher> getTeachers() {
		return this.teachers;
	}

	/**
	 * @param teachers
	 *            the teachers to set
	 */
	public final void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	/**
	 * @return the classrooms
	 */
	public final Set<Classroom> getClassrooms() {
		return this.classrooms;
	}

	/**
	 * @param classrooms
	 *            the classrooms to set
	 */
	public final void setClassrooms(Set<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	/**
	 * @return the disciplines
	 */
	public final Set<Discipline> getDisciplines() {
		return this.disciplines;
	}

	/**
	 * @param disciplines
	 *            the disciplines to set
	 */
	public final void setDisciplines(Set<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	/**
	 * @return the groups
	 */
	public final Set<Group> getGroups() {
		return this.groups;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public final void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @return the teacherDisciplines
	 */
	public final Set<TeacherDiscipline> getTeacherDisciplines() {
		return this.teacherDisciplines;
	}

	/**
	 * @param teacherDisciplines
	 *            the teacherDisciplines to set
	 */
	public final void setTeacherDisciplines(Set<TeacherDiscipline> teacherDisciplines) {
		this.teacherDisciplines = teacherDisciplines;
	}

	/**
	 * @return the disciplineGroups
	 */
	public final Set<DisciplineGroup> getDisciplineGroups() {
		return this.disciplineGroups;
	}

	/**
	 * @param disciplineGroups
	 *            the disciplineGroups to set
	 */
	public final void setDisciplineGroups(Set<DisciplineGroup> disciplineGroups) {
		this.disciplineGroups = disciplineGroups;
	}

	/**
	 * @return the teacherDisciplineGroups
	 */
	public final Set<TeacherDisciplineGroup> getTeacherDisciplineGroups() {
		return this.teacherDisciplineGroups;
	}

	/**
	 * @param teacherDisciplineGroups
	 *            the teacherDisciplineGroups to set
	 */
	public final void setTeacherDisciplineGroups(Set<TeacherDisciplineGroup> teacherDisciplineGroups) {
		this.teacherDisciplineGroups = teacherDisciplineGroups;
	}

	/**
	 * @return the teacherClassroomWhite
	 */
	public final Set<TeacherClassroom> getTeacherClassroomWhite() {
		return this.teacherClassroomWhite;
	}

	/**
	 * @param teacherClassroomWhite
	 *            the teacherClassroomWhite to set
	 */
	public final void setTeacherClassroomWhite(Set<TeacherClassroom> teacherClassroomWhite) {
		this.teacherClassroomWhite = teacherClassroomWhite;
	}

	/**
	 * @return the teacherClassroomBlack
	 */
	public final Set<TeacherClassroom> getTeacherClassroomBlack() {
		return this.teacherClassroomBlack;
	}

	/**
	 * @param teacherClassroomBlack
	 *            the teacherClassroomBlack to set
	 */
	public final void setTeacherClassroomBlack(Set<TeacherClassroom> teacherClassroomBlack) {
		this.teacherClassroomBlack = teacherClassroomBlack;
	}

	/**
	 * @return the disciplineClassroomWhite
	 */
	public final Set<DisciplineClassroom> getDisciplineClassroomWhite() {
		return this.disciplineClassroomWhite;
	}

	/**
	 * @param disciplineClassroomWhite
	 *            the disciplineClassroomWhite to set
	 */
	public final void setDisciplineClassroomWhite(Set<DisciplineClassroom> disciplineClassroomWhite) {
		this.disciplineClassroomWhite = disciplineClassroomWhite;
	}

	/**
	 * @return the disciplineClassroomBlack
	 */
	public final Set<DisciplineClassroom> getDisciplineClassroomBlack() {
		return this.disciplineClassroomBlack;
	}

	/**
	 * @param disciplineClassroomBlack
	 *            the disciplineClassroomBlack to set
	 */
	public final void setDisciplineClassroomBlack(Set<DisciplineClassroom> disciplineClassroomBlack) {
		this.disciplineClassroomBlack = disciplineClassroomBlack;
	}

	/**
	 * @return the lessons
	 */
	public final Set<Lesson> getLessons() {
		return this.lessons;
	}

	/**
	 * @param lessons
	 *            the lessons to set
	 */
	public final void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}
}
