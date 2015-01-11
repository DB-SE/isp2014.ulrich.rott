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

	private int checkPassword(String password) throws SQLException {
		/*
		 * String stmt = "SELECT password, uid FROM users WHERE username = ?";
		 * PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		 * ps.setString(1, username); db.runStmt(ps);
		 */
		// TODO get uid from Database
		int DBuID = 100;
		// if (ps.getResultSet().getString(0) == password){
		status = true;
		System.out.println("\t\t- login success -");
		/*
		 * } else { System.out.println("- login failed -"); status = false }
		 */
		return DBuID;
	}
}
