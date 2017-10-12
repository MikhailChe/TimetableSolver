/**
 * 
 */
package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.dolika.timetable.models.Discipline;
import ru.dolika.timetable.models.Group;
import ru.dolika.timetable.models.Lesson;

/**
 * @author Mikhail
 *
 */
public class LessonTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testConstructorVararg() {

		Lesson l = null;
		try {
			l = new Lesson(new Group(30, 10, 'A'), new Discipline("Физика"));
		} catch (NullPointerException e) {
			return;
		}
		Assert.fail("No null pointer exception.");

	}

	/**
	 * Test method for {@link ru.dolika.timetable.models.Lesson#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#Lesson(ru.dolika.timetable.models.Group, ru.dolika.timetable.models.Discipline, java.util.Set)}.
	 */
	@Test
	public final void testLessonGroupDisciplineSetOfTeacher() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#Lesson(ru.dolika.timetable.models.Group, ru.dolika.timetable.models.Discipline, ru.dolika.timetable.models.Teacher[])}.
	 */
	@Test
	public final void testLessonGroupDisciplineTeacherArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ru.dolika.timetable.models.Lesson#toString()}.
	 */
	@Test
	public final void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Lesson#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		fail("Not yet implemented");
	}

}
