/**
 * 
 */
package test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;

import ru.dolika.timetable.models.Classroom;

/**
 * @author Mikhail
 *
 */
public class ClassroomTest {

	/**
	 * Test method for {@link ru.dolika.timetable.models.Classroom#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		assertEquals(new Classroom(0, "7", 1, -1).hashCode(), new Classroom(0, "7", 1, -1).hashCode());
		assertEquals(new Classroom(1, "7", 1, -1).hashCode(), new Classroom(1, "7", 1, -1).hashCode());
		assertEquals(new Classroom(1, "8", 1, -1).hashCode(), new Classroom(1, "8", 1, -1).hashCode());
		assertEquals(new Classroom(1, "8", 2, -1).hashCode(), new Classroom(1, "8", 2, -1).hashCode());
		assertEquals(new Classroom(1, "8", 2, 40).hashCode(), new Classroom(1, "8", 2, 40).hashCode());
		assertNotEquals(new Classroom(0, "7", 1, -1).hashCode(), new Classroom(1, "7", 1, -1).hashCode());
		assertNotEquals(new Classroom(0, "7", 1, -1).hashCode(), new Classroom(0, "8", 1, -1).hashCode());
		assertNotEquals(new Classroom(0, "7", 1, -1).hashCode(), new Classroom(0, "7", 2, -1).hashCode());
		assertNotEquals(new Classroom(0, "7", 1, -1).hashCode(), new Classroom(0, "7", 1, 30).hashCode());
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Classroom#Classroom(long, java.lang.String, int, int)}.
	 */
	@Test
	public final void testClassroomLongStringIntInt() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c = new Classroom(id, s, numClasses, numStudents);

			assertEquals(id, c.getId());
			assertEquals(s, c.getName());
			assertEquals(numClasses, c.getClassesAllowed());
			assertEquals(numStudents, c.getNumStudentsAllowed());
		}
		{
			long id = tlr.nextLong();
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();
			Classroom c = null;
			try {
				c = new Classroom(id, null, numClasses, numStudents);
			} catch (NullPointerException e) {

			}

			Assert.assertNull(c);
		}
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Classroom#Classroom(java.lang.String)}.
	 */
	@Test
	public final void testClassroomString() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());

			Classroom c = new Classroom(s);

			assertNotEquals(id, c.getId());
			assertEquals(s, c.getName());
			assertEquals(-1, c.getClassesAllowed());
			assertEquals(-1, c.getNumStudentsAllowed());
		}
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.Classroom#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		ThreadLocalRandom tlr = ThreadLocalRandom.current();
		// this == obj
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			Classroom c2 = c1;

			assertEquals(c1, c2);
			Assert.assertTrue("Equals не работает", c1.equals(c2));
			assertEquals(c1.toString(), c2.toString());
		}

		// obj == null
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, null);
			Assert.assertFalse("Equals не работает", c1.equals(null));
		}

		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, new Double(2.0));
			Assert.assertFalse("Equals не работает", c1.equals(new Double(2.0)));
		}

		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			Classroom c2 = new Classroom(id, s, numClasses, numStudents);

			assertEquals(c1, c2);
			Assert.assertTrue("Equals не работает", c1.equals(c2));
			assertEquals(c1.toString(), c2.toString());
		}

		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			id = tlr.nextLong();
			Classroom c2 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, c2);
			assertFalse("Equals не работает", c1.equals(c2));
			assertNotEquals(c1.toString(), c2.toString());

		}
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			s = Double.toString(tlr.nextDouble());
			Classroom c2 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, c2);
			assertFalse("Equals не работает", c1.equals(c2));
			assertNotEquals(c1.toString(), c2.toString());

		}
		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			numClasses = tlr.nextInt();
			Classroom c2 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, c2);
			assertFalse("Equals не работает", c1.equals(c2));
			assertNotEquals(c1.toString(), c2.toString());
		}

		for (int i = 0; i < 100; i++) {
			long id = tlr.nextLong();
			String s = Double.toString(tlr.nextDouble());
			int numClasses = tlr.nextInt();
			int numStudents = tlr.nextInt();

			Classroom c1 = new Classroom(id, s, numClasses, numStudents);

			numStudents = tlr.nextInt();
			Classroom c2 = new Classroom(id, s, numClasses, numStudents);

			assertNotEquals(c1, c2);
			assertFalse("Equals не работает", c1.equals(c2));
			assertNotEquals(c1.toString(), c2.toString());
		}
	}
}
