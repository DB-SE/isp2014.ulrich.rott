import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {
	public void login() throws SQLException {
		String[] userInput = new String[2];
		userInput = getUserInput();
		this.username = userInput[0];
		uid = checkPassword(userInput[1]);
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

	public static String[] getUserInput() {
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
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("login");
		return Functions;
	}
}
