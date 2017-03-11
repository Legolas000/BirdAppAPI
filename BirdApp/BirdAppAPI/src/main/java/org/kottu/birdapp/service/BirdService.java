package org.kottu.birdapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.kottu.birdapp.model.Birds;
import org.kottu.birdapp.model.Users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class BirdService {

	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;
	
	public String[] insertBirds(Birds bird)
	{
		String[] respArr = new String[2];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String query = "INSERT INTO Birds(Bird_Name, Scientific_Name, Regional_Name, Image, Email) VALUES(?, ?, ?, ?, ?)";
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, bird.getBird_Name());
			pstmt.setString(2, bird.getScientific_Name());
			pstmt.setString(3, bird.getRegional_Name());
			pstmt.setString(4, bird.getImage());
			pstmt.setString(5, bird.getEmail());
			
			Boolean ival = pstmt.execute();
			if(ival)
			{
				respArr[0] = "SUCC";
				respArr[1] = "The bird has been succesfully inserted";
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
	
	public String[] getBirdDetails(){
		List<Birds> list = new ArrayList<Birds>();
		
		String[] respArr = new String[2];
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM Birds";
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Birds bird = new Birds();
				bird.setBirdCode(rs.getString(1));
				bird.setBird_Name(rs.getString(2));
				bird.setScientific_Name(rs.getString(3));
				bird.setRegional_Name(rs.getString(4));
				bird.setImage(rs.getString(5));
				
				list.add(bird);
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		if(list.isEmpty()){
			respArr[0] = "EMPARR";
			return respArr;
		}
		else{
			Gson gson = new GsonBuilder().create();
			JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();
	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", myCustomArray);
			System.out.print(jsonObject.toString());
			
			respArr[0] = "SUCC";
			respArr[1] = jsonObject.toString();
			
			return respArr;
		}
	}
	
	public String[] searchBirdDetails(String birdDets){
		List<Birds> list = new ArrayList<Birds>();
		
		String[] respArr = new String[2];
		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM Birds WHERE BirdName LIKE %?% OR Regional_Name LIKE %?%";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, birdDets);
			pstmt.setString(2, birdDets);
			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				Birds bird = new Birds();
				bird.setBirdCode(rs.getString(1));
				bird.setBird_Name(rs.getString(2));
				bird.setScientific_Name(rs.getString(3));
				bird.setRegional_Name(rs.getString(4));
				bird.setImage(rs.getString(5));
				
				list.add(bird);
			}
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		if(list.isEmpty()){
			respArr[0] = "EMPARR";
			return respArr;
		}
		else{
			Gson gson = new GsonBuilder().create();
			JsonArray myCustomArray = gson.toJsonTree(list).getAsJsonArray();
	
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", myCustomArray);
			System.out.print(jsonObject.toString());
			
			respArr[0] = "SUCC";
			respArr[1] = jsonObject.toString();
			
			return respArr;
		}
	}
}
