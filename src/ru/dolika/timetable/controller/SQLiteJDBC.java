package ru.dolika.timetable.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBC implements AutoCloseable {

	private Connection conn = null;
	String dbname = "tt.db";

	public SQLiteJDBC() {

	}

	public SQLiteJDBC setDB(String dbname) {
		this.dbname = dbname;
		return this;
	}

	public SQLiteJDBC connect() throws SQLException {
		String url = "jdbc:sqlite:" + this.dbname;

		this.setConn(DriverManager.getConnection(url));
		System.out.println("Соединение к базе данных установлено");
		return this;

	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return this.conn;
	}

	/**
	 * @param conn
	 *            the conn to set
	 */
	private void setConn(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void close() throws SQLException {
		if (this.getConn() != null) {
			this.getConn().close();
		}
	}
}
