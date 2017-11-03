package ru.dolika.timetable.controller;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import javax.swing.WindowConstants;

import ru.dolika.timetable.models.School;
import ru.dolika.timetable.models.Teacher;
import ru.dolika.timetable.view.TeacherViewer;

public class Main implements Runnable {

	public static void main(String... strings) {
		new Main().run();
	}

	@Override
	public void run() {
		final School school = new School();
		Set<Teacher> teachers = new HashSet<>();

		school.setTeachers(teachers);
		teachers.add(new Teacher("Михаил", "Юрьевич", "Черноскутов"));
		teachers.add(new Teacher("Владислав", "Витальевич", "Мешков"));
		teachers.add(new Teacher("Татьяна", "Валерьевна", "Рыжкова"));
		teachers.add(new Teacher("Олеся", "Андреевна", "Неуймина"));
		teachers.add(new Teacher("Антон", "Олегович", "Самойлов"));
		teachers.add(new Teacher("Сергей", "Сергеевич", "Венков"));

		final TeacherViewer teacherViewer = new TeacherViewer(school.getTeachers());

		teacherViewer.setVisible(true);
		teacherViewer.addOnDeleteActionListener(t -> {
			school.getTeachers().remove(t);
			System.out.println("Остались: "
					+ school.getTeachers().stream().map(Teacher::toString).collect(Collectors.joining(",")));
		});

		teacherViewer.addOnAddActionListener(t -> {
			school.getTeachers().add(t);
			System.out.println("Остались: "
					+ school.getTeachers().stream().map(Teacher::toString).collect(Collectors.joining(",")));
		});

		teacherViewer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
