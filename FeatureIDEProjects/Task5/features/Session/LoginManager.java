import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager implements FeatureInterface{
	private int uid;
	private String username;
	private boolean status;
	private dbConnector db;

	public LoginManager() {
		this.uid = -1;
		this.username = "NOT SET";
		this.status = false;
		this.db = new dbConnector();
	}

	public boolean getStatus() {
		if (status) {
			System.out.println("\t\tYour are logged in");
		} else {
			System.out.println("\t\tYour are not logged in");
		}
		return status;
	}

	public int getUid() {
		return uid;
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
	public int getID(){
		return 2;
	}
	
	@Override
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("getUid");
		Functions.add("getStatus");
		return Functions;
	}
}
