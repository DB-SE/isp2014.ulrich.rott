import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {
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

	public void logout() {
		status = false;
		System.out.println("Logout success!");
	}
}
