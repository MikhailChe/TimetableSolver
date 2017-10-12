package ru.dolika.timetable.controller;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import ru.dolika.timetable.models.Discipline;
import ru.dolika.timetable.models.DisciplineGroup;
import ru.dolika.timetable.models.Group;
import ru.dolika.timetable.models.Teacher;
import ru.dolika.timetable.models.TeacherDiscipline;

public class Main {

	public static void main(String... strings) {
		Teacher teacher = new Teacher("Михаил", "Юрьевич", "Черноскутов");
		Discipline discipline = new Discipline("Физика");
		Group gr8a = new Group(30, 8, 'a');
		Group gr8b = new Group(28, 8, 'b');

		DisciplineGroup grdis1 = new DisciplineGroup(0, gr8a, discipline);
		DisciplineGroup grdis2 = new DisciplineGroup(0, gr8b, discipline);

		TeacherDiscipline teacherDiscipline = new TeacherDiscipline(0, teacher, discipline);

		System.out.println("Teacher: " + teacher);
		System.out.println("Discipline: " + discipline);
		System.out.println("groups: " + gr8a + ",    " + gr8b);
		System.out.println("Disciplines of Teacher: " + teacherDiscipline);

		System.out.println("Disciplines of Group: " + grdis1);
		System.out.println("Disciplines of Group: " + grdis2);

	}

	public static void main2(String... strings) {
		try (SQLiteJDBC sqldrv = new SQLiteJDBC()) {
			sqldrv.setDB("tt.db").connect();
			System.out.println("Автоматический коммит: " + sqldrv.getConn().getAutoCommit());
			DatabaseMetaData dbmd = sqldrv.getConn().getMetaData();
			System.out.println("База данных: " + dbmd.getDatabaseProductName());
			System.out.println("Версия БД: " + dbmd.getDatabaseProductVersion());
			System.out.println("Драйвер: " + dbmd.getDriverName() + ". Версия: " + dbmd.getDriverVersion() + " "
					+ dbmd.getDriverMajorVersion() + "." + dbmd.getDriverMinorVersion());

			System.out.println("Каталог:" + sqldrv.getConn().getCatalog());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void threadLocalRandomTest(String... strings) {
		ThreadLocalRandom r = ThreadLocalRandom.current();

		final int NUMBucks = 30;

		int[] freq = new int[NUMBucks];

		final int TOTAL = 10;

		for (int i = 0; i < TOTAL; i++) {
			freq[r.nextInt(NUMBucks)]++;
		}

		for (int i = 0; i < NUMBucks; i++) {
			System.out.println(i + ":  " + ((double) freq[i] / (double) TOTAL * 100.0));
		}

	}

}
