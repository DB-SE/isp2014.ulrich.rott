package main;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public void login() throws SQLException{
		String[] userInput = new String[2];
		userInput = getUserInput();
		this.username = userInput[0];
		uid = checkPassword(userInput[1]);
	}
	
	public void logout(){
		status = false;
		System.out.println("Logout success!");
	}
	
	public boolean getStatus(){
		if (status){
			System.out.println("\t\tYour are logged in");
		} else {
			System.out.println("\t\tYour are not logged in");
		}
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
			System.out.println("\t\t- login success -");
		/*} else {
			System.out.println("- login failed -");
			status = false
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
	
	public static String[] getUserInput(){
		String[] result = new String[2];
		
		System.out.print("User: ");
		Scanner userInput = new Scanner(System.in);
		result[0] = userInput.nextLine();
        userInput.reset();
        
        System.out.print("Password: ");
        Scanner passwordInput = new Scanner(System.in);
        result[1] = userInput.nextLine();
        userInput.reset();
        System.out.println();
        
		return result;
	}
}
