/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ru.dolika.timetable.models.Discipline;
import ru.dolika.timetable.models.Group;
import ru.dolika.timetable.models.Lesson;
import ru.dolika.timetable.models.Teacher;

/**
 * @author Mikhail
 *
 */
public class LessonTest {

	Group g;
	Discipline d;
	Set<Teacher> t;

	@Before
	public void setup() {
		this.g = new Group(30, 10, 'А');
		this.d = new Discipline("Физика");
		this.t = new HashSet<>(Arrays.asList(new Teacher("Михаил", "Юрьевич", "Черноскутов")));
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#Lesson(ru.dolika.timetable.models.Group, ru.dolika.timetable.models.Discipline, java.util.Set)}.
	 */
	@Test
	public final void testLessonGroupDisciplineSetOfTeacher() {
		Lesson l = new Lesson(this.g, this.d, this.t);
		assertTrue(l.getDiscipline().equals(this.d));
		assertTrue(l.getGroup().equals(this.g));
		assertTrue(l.getTeachers().equals(this.t));

		l = null;
		try {
			l = new Lesson(null, this.d, this.t);
		} catch (NullPointerException e) {

		}
		assertNull(l);

		try {
			l = new Lesson(this.g, null, this.t);
		} catch (NullPointerException e) {

		}
		assertNull(l);

		try {
			l = new Lesson(this.g, this.d, (Set<Teacher>) null);
		} catch (NullPointerException e) {

		}
		assertNull(l);
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#Lesson(ru.dolika.timetable.models.Group, ru.dolika.timetable.models.Discipline, ru.dolika.timetable.models.Teacher[])}.
	 */
	@Test
	public final void testLessonGroupDisciplineTeacherArray() {
		Lesson l = null;

		l = new Lesson(this.g, this.d, new Teacher("Колмогоров", "Денис", "Борисович"));
		assertNotNull(l);

		l = null;
		try {
			l = new Lesson(this.g, this.d);
		} catch (NullPointerException e) {

		}
		assertNull(l);
		try {
			l = new Lesson(null, new Discipline("Физика"), new Teacher("Колмогоров", "Денис", "Борисович"));
		} catch (NullPointerException e) {

		}
		assertNull(l);

		try {
			l = new Lesson(new Group(30, 10, 'A'), null, new Teacher("Колмогоров", "Денис", "Борисович"));
		} catch (NullPointerException e) {

		}
		assertNull(l);

	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		Lesson l = new Lesson(this.g, this.d, this.t);
		Lesson l2 = new Lesson(this.g, this.d, this.t);

		assertTrue(l.equals(l2));
		assertTrue(l2.equals(l));
		assertEquals(l.toString(), l2.toString());
		assertEquals(l.hashCode(), l2.hashCode());

		assertFalse(l.equals(null));
		assertFalse(l2.equals(null));

		assertFalse(l.equals(new Object()));
		assertFalse(l2.equals(new Object()));

		assertTrue(l.equals(l));
		assertTrue(l2.equals(l2));

		assertFalse(l.equals(new Lesson(new Group(10, 8, 'Б'), this.d, this.t)));
		assertFalse(l.equals(new Lesson(this.g, new Discipline("Химия"), this.t)));
		assertFalse(l.equals(new Lesson(this.g, this.d,
				new HashSet<>(Arrays.asList(new Teacher("Владислав", "Витальевич", "Мешков"))))));

	}

}
