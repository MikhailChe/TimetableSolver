package ru.dolika.timetable.controller;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable {

	public static void main(String... strings) {
		new Main().run();
	}

	@Override
	public void run() {
		
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
