/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ru.dolika.timetable.models.collection.Multimap;

/**
 * @author Mikhail
 *
 */
public class MultimapTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	public MultimapTest() {
		// TODO Auto-generated constructor stub
	}

	Multimap<Integer, String> mm;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mm = new Multimap<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.collection.Multimap#Multimap()}.
	 */
	@Test
	public final void testMultimap() {
		assertNotNull(this.mm);
		assertNull(this.mm.getKeysByValue("Loolol"));
		assertNull(this.mm.getValuesByKey(12));

	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.collection.Multimap#add(java.lang.Object, java.lang.Object)}.
	 */
	@Test
	public final void testAdd() {
		this.mm.add(10, "Ololo").add(10, "Atata").add(12, "Ololo").add(12, "Trol").add(12, "GONV");
		List<String> sss = this.mm.getValuesByKey(10);
		assertEquals(2, sss.size());
		sss = this.mm.getValuesByKey(12);
		assertEquals(3, sss.size());
		sss = this.mm.getValuesByKey(5);
		assertNull(sss);

	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.collection.Multimap#getValuesByKey(java.lang.Object)}.
	 */
	@Test
	public final void testGetValuesByKey() {
		this.mm.add(10, "Atata").add(12, "ololo");
		List<String> sss = this.mm.getValuesByKey(10);
		assertEquals(1, sss.size());
		assertEquals("Atata", sss.get(0));

		sss = this.mm.getValuesByKey(12);
		assertEquals(1, sss.size());
		assertEquals("ololo", sss.get(0));
	}

	/**
	 * Test method for
	 * {@link ru.dolika.timetable.models.collection.Multimap#getKeysByValue(java.lang.Object)}.
	 */
	@Test
	public final void testGetKeysByValue() {
		this.mm.add(10, "Ololo").add(10, "Atata").add(12, "Ololo").add(12, "Trol").add(12, "GONV");

		List<Integer> iii = this.mm.getKeysByValue("Ololo");
		assertEquals(2, iii.size());

		iii = this.mm.getKeysByValue("Atata");
		assertEquals(1, iii.size());
		assertEquals((int) 10, (int) (iii.get(0)));

	}

}
