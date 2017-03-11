package org.sgit.birdapp.service;

public class DBconnect {

	String connectionUrl;
	String Username;
	String Password;

	public String connectionString() {

		try {

			connectionUrl = "jdbc:mysql://localhost/test";
			Username = "root";
			Password = "";

		} catch (Exception e) {
			e.printStackTrace();

		}

		return connectionUrl;

	}

}
