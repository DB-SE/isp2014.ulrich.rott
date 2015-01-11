import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 

public   class  UserManager  implements FeatureInterface {
	
	private int uid;

	
	private dbConnector db;

	

	public UserManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
	}

	

	private PreparedStatement fillValues(PreparedStatement ps, User user) throws SQLException {
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getRealname());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		return ps;
	}

	
	
	@Override
	public String getTitle() {
		return "UserManager";
	}

	

	@Override
	public String getDescription() {
		return "Manger of registred Users";
	}

	

	
	 private ArrayList<String>  getFunctions__wrappee__Users() {
		ArrayList<String> Functions = new ArrayList<String>();
		return Functions;
	}

	
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = getFunctions__wrappee__Users();
		Functions.add("insert");
		return Functions;
	}

	

	@Override
	public int getID() {
		return 3;
	}

	
	public void createNew(User user) throws SQLException {
		String stmt = "INSERT INTO users (username, realname, email, password) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, user);
		db.runStmt(ps);
	}

	
	public void show(int uid) throws SQLException {
		String stmt = "SELECT * FROM users WHERE uid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, uid);
		// TODO
		db.runStmt(ps);
	}


}
