package main;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.dbConnector;
import interfaces.*;

public class LoginManager implements DataPlugin{
	private int uid;
	private String username;
	private boolean status;
	private dbConnector db;
	
	public LoginManager(){
		this.uid = -1;
		this.username = "NOT SET";
		this.status = false;
		this.db = new dbConnector();
	}
	
	public void login(String username, String password) throws SQLException{
		this.username = username;
		uid = checkPassword(password);
	}
	
	public void logout(){
		
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public int getUid(){
		return uid;
	}

	private int checkPassword(String password) throws SQLException{
		/*
		String stmt = "SELECT password, uid FROM users WHERE username = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setString(1, username);
		db.runStmt(ps);
		*/
		//TODO get uid from Database
		int DBuID = 100;
		//if (ps.getResultSet().getString(0) == password){
			status = true;
			System.out.println("- login success -");
		/*} else {
			System.out.println("- login failed -");
		}*/
		return DBuID;
	}
	
	@Override
	public String getTitle() {
		return "LoginManager";
	}

	@Override
	public String getDescription() {
		return "Manager of accesss";
	}

	@Override
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("login");
		Functions.add("logout");
		Functions.add("getUid");
		Functions.add("getStatus");
		return Functions;
	}

	@Override
	public int getID() {
		return 0;
	}

}
