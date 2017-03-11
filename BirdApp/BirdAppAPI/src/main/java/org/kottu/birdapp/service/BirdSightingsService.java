package org.kottu.birdapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.kottu.birdapp.model.BirdSightings;

public class BirdSightingsService {
	
	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;
	
	
	public String[] insertBirdSight(BirdSightings birdSighting)
	{
		String[] respArr = new String[2];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String query = "INSERT INTO BirdSight(SightedDate, StartSightedTime, EndSightedTime, Location, BirdCode,Email) VALUES(?, ?, ?, ?, ?, ?)";
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, birdSighting.getSightedDate());
			pstmt.setString(2, birdSighting.getStartSightedTime());
			pstmt.setString(3, birdSighting.getEndSightedTime());
			pstmt.setString(4, birdSighting.getLocation());
			pstmt.setString(5, birdSighting.getBirdCode());
			pstmt.setString(6, birdSighting.getEmail());
			
			Boolean ival = pstmt.execute();
			if(ival)
			{
				respArr[0] = "SUCC";
				respArr[1] = "The birdsighting has been succesfully inserted";
				return respArr;
			}
			else
			{
				respArr[0] = "ERR";
				respArr[1] = "An error occured please try again";
				return respArr;
			}
 			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (cstmt != null)
				try {
					cstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
		
		respArr[0] = "FERR";
		respArr[2] = "An error occured pls try again";
		return respArr;
	}
}
