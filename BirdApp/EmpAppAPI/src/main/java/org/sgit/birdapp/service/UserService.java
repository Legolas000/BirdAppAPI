package org.sgit.birdapp.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sgit.birdapp.model.Users;
import org.sgit.birdapp.service.DBconnect;

public class UserService {

	DBconnect connect = new DBconnect();
	String connectionUrl = connect.connectionString();

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;
	
	public String[] insertUsers(Users user)
	{
		String[] respArr = new String[2];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String query = "INSERT INTO Users(Email, Name, phoneNo, Password) VALUES(?, ?, ?, ?)";
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPhoneNo());
			pstmt.setString(4, user.getPassword());
			
			Boolean ival = pstmt.execute();
			if(ival)
			{
				respArr[0] = "SUCC";
				respArr[1] = "The user have been succesfully created";
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
	
	
	public String[] loginUser(Users user)
	{
		String[] respArr = new String[2];
		int ReturnVal = 0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			System.out.print("Connected.<br/>");

			String query = "SELECT FROM Users WHERE Email = ? AND Password = ?";
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			
			rs = pstmt.executeQuery(query);
			if(rs.first())
			{
				respArr[0] = "SUCC";
				respArr[1] = "The user have been succesfully logged";
				return respArr;
			}
			else
			{
				respArr[0] = "ERR";
				respArr[1] = "The User details are incorrect please try again";
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
