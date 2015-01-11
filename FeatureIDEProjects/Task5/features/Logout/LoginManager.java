import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {
	public void logout() {
		status = false;
		System.out.println("Logout success!");
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("logout");
		return Functions;
	}
}
