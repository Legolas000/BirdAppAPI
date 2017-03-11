package org.sgit.birdapp.service;

public class DBconnect {

	String connectionUrl;

	public String connectionString() {

		try {
			
			connectionUrl = "jdbc:sqlserver://birdapp.database.windows.net:1433;database=BirdApp;user=pandababy@birdapp;password=Sscmalith124.;";
		} catch (Exception e) {
			e.printStackTrace();

		}

		return connectionUrl;

	}

}
