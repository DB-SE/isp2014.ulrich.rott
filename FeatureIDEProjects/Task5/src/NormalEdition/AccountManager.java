import java.sql.Date; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 

public   class  AccountManager  implements FeatureInterface {
	
	private int uid;

	
	private dbConnector db;

	
	private TransactionManager tm;

	

	public AccountManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
		this.tm = new TransactionManager(uid);
	}

	

	private PreparedStatement fillValues(PreparedStatement ps, Account account) throws SQLException {
		ps.setString(1, account.getAtitle());
		ps.setString(2, account.getAdescription());
		ps.setFloat(3, account.getAamount());
		return ps;
	}

	
	
	@Override
	public String getTitle() {
		return "AccountManager";
	}

	

	@Override
	public String getDescription() {
		return "Manage of Accounts";
	}

	

	
	 private ArrayList<String>  getFunctions__wrappee__Accounts() {
		ArrayList<String> Functions = new ArrayList<String>();
		return Functions;
	}

	
	
	 private ArrayList<String>  getFunctions__wrappee__aInsertion  () {
		ArrayList<String> Functions = getFunctions__wrappee__Accounts();
		Functions.add("create");
		return Functions;
	}

	
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = getFunctions__wrappee__aInsertion();
		Functions.add("show");
		return Functions;
	}

	

	@Override
	public int getID() {
		return 1;
	}

	
	public void createNew(Account account) throws SQLException {
		String stmt = "INSERT INTO accounts (atitle, adescription, aamount, uid) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, uid);
		db.runStmt(ps);
	}

	
	public void show(int aid) throws SQLException {
		String stmt = "SELECT * FROM accounts WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
		// TODO
		db.runStmt(ps);
	}


}
