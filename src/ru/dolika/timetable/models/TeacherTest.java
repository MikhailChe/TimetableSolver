package ru.dolika.timetable.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeacherTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetUniqueID() {
		assertEquals(new Teacher("Ч", "М", "Ю").getUniqueID(), new Teacher("Ч", "М", "Ю").getUniqueID());
	}

	@Test
	public final void testTeacher() {
		String a = "@ASDASD";
		String b = "(UFS(DJF";
		String c = "ALJDFOIOI@#";
		Teacher t = new Teacher(a, b, c);
		assertEquals(t.getName(), a);
		assertEquals(t.getMiddleName(), b);
		assertEquals(t.getLastName(), c);

		t = null;

		try {
			t = new Teacher(null, b, c);
		} catch (Exception e) {

		}
		assertNull(t);

		try {
			t = new Teacher(a, null, c);
		} catch (Exception e) {

		}
		assertNull(t);

		try {
			t = new Teacher(a, b, null);
		} catch (Exception e) {

		}
		assertNull(t);

		try {
			t = new Teacher(null, null, null);
		} catch (Exception e) {

		}
		assertNull(t);

	}

	@Test
	public final void testEqualsObject() {
		Teacher[] t = { new Teacher("А", "А", "А"), new Teacher("А", "А", "А"), new Teacher("А", "А", "Б"),
				new Teacher("Б", "А", "Б"), new Teacher("Б", "Б", "Б") };

		assertTrue(t[0].equals(t[1]));
		assertTrue(t[0].equals(t[0]));

		assertEquals(t[0].toString(), t[1].toString());
		assertEquals(t[0].hashCode(), t[1].hashCode());

		assertNotEquals(t[1], t[2]);
		assertNotEquals(t[1], t[3]);
		assertNotEquals(t[1], t[4]);

		assertNotEquals(t[2], t[3]);
		assertNotEquals(t[2], t[4]);

		assertNotEquals(t[3], t[4]);

		assertNotEquals(t[0], new Object());
		assertNotEquals(t[1], new Object());
		assertNotEquals(t[2], new Object());
		assertNotEquals(t[3], new Object());
		assertNotEquals(t[4], new Object());

	}

	@Test
	public final void testCompareTo() {
		Teacher[] t = { new Teacher("А", "А", "А"), new Teacher("А", "А", "Б"), new Teacher("Б", "А", "Б"),
				new Teacher("Б", "Б", "Б") };

		assertTrue(t[0].compareTo(t[0]) == 0);
		assertTrue(t[0].compareTo(t[1]) < 0);
		assertTrue(t[0].compareTo(t[2]) < 0);
		assertTrue(t[0].compareTo(t[3]) < 0);

		assertTrue(t[1].compareTo(t[0]) > 0);
		assertTrue(t[1].compareTo(t[1]) == 0);
		assertTrue(t[1].compareTo(t[2]) < 0);
		assertTrue(t[1].compareTo(t[3]) < 0);

		assertTrue(t[2].compareTo(t[0]) > 0);
		assertTrue(t[2].compareTo(t[1]) > 0);
		assertTrue(t[2].compareTo(t[2]) == 0);
		assertTrue(t[2].compareTo(t[3]) < 0);

		assertTrue(t[3].compareTo(t[0]) > 0);
		assertTrue(t[3].compareTo(t[1]) > 0);
		assertTrue(t[3].compareTo(t[2]) > 0);
		assertTrue(t[3].compareTo(t[3]) == 0);

	}

}
