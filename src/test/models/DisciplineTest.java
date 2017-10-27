package test.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ru.dolika.timetable.models.Discipline;

public class DisciplineTest {

	@Test
	public final void testEqualsObject() {
		assertEquals(new Discipline("Физика"), new Discipline("Физика"));
		assertEquals(new Discipline("Физика").toString(), new Discipline("Физика").toString());
		assertEquals(new Discipline("Физика").hashCode(), new Discipline("Физика").hashCode());
		assertNotEquals(new Discipline("Фиика"), new Discipline("Физика"));

		assertEquals(new Discipline("Фиизка", 1, 1), new Discipline("Фиизка", 1, 1));
		assertEquals(new Discipline("Фиизка", 1, 1), new Discipline("Фиизка", 1, 2));
		assertEquals(new Discipline("Фиизка", 1, 1), new Discipline("Фиизка", 2, 1));
		assertNotEquals(new Discipline("Фиизка", 1, 1), new Discipline("Фиизк", 1, 1));

		assertNotEquals(null, new Discipline("Физика"));
		assertFalse(new Discipline("Физика").equals(null));
		assertFalse(new Discipline("Физика").equals(new Object()));
		Discipline d = new Discipline("Физика");
		assertEquals(d, d);

		assertNotEquals(new Object(), d);

	}

	@Test
	public final void testDisciplineString() {
		Discipline d = new Discipline("Физика");
		assertEquals(d.getName(), "Физика");
		assertEquals(d.getScore(), 1);
		assertEquals(d.getSubdivisionFactor(), 1);

		d = null;
		try {
			d = new Discipline(null);
		} catch (NullPointerException e) {

		}
		assertEquals(d, null);
	}

	@Test
	public final void testDisciplineStringLongInt() {
		Discipline d = new Discipline("Физика", 2, 3);
		assertEquals(d.getName(), "Физика");
		assertEquals(d.getScore(), 2);
		assertEquals(d.getSubdivisionFactor(), 3);
	}

}
