import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.Scanner; 

public   class  LoginManager  implements FeatureInterface {
	
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

	
	
	
	 private ArrayList<String>  getFunctions__wrappee__Session() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("getUid");
		Functions.add("getStatus");
		return Functions;
	}

	
	
	 private ArrayList<String>  getFunctions__wrappee__Login  () {
		ArrayList<String> Functions = getFunctions__wrappee__Session();
		Functions.add("login");
		return Functions;
	}

	
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = getFunctions__wrappee__Login();
		Functions.add("logout");
		return Functions;
	}

	
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

	
	public void logout() {
		status = false;
		System.out.println("Logout success!");
	}


}
