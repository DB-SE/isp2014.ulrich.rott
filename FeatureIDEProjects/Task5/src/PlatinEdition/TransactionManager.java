import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 

public   class  TransactionManager  implements FeatureInterface {
	
	private int uid;

	
	private dbConnector db;

	

	public TransactionManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
	}

	

	private PreparedStatement fillValues(PreparedStatement ps, Transaction transaction) throws SQLException {
		ps.setString(1, transaction.getDescription());
		ps.setFloat(2, transaction.getAmount());
		ps.setDate(3, transaction.getDate());
		ps.setInt(4, transaction.getCid());
		ps.setInt(5, transaction.getAid());
		return ps;
	}

	

	@Override
	public String getTitle() {
		return "TransactionsManager";
	}

	

	@Override
	public String getDescription() {
		return "Manager of the Transactions";
	}

	

	
	 private ArrayList<String>  getFunctions__wrappee__Transaktion() {
		ArrayList<String> Functions = new ArrayList<String>();
		return Functions;
	}

	
	
	 private ArrayList<String>  getFunctions__wrappee__tInsertion  () {
		ArrayList<String> Functions = getFunctions__wrappee__Transaktion();
		Functions.add("create");
		return Functions;
	}

	
	
	 private ArrayList<String>  getFunctions__wrappee__tModification  () {
		ArrayList<String> Functions = getFunctions__wrappee__tInsertion();
		Functions.add("modify");
		return Functions;
	}

	
	
	 private ArrayList<String>  getFunctions__wrappee__tDelete  () {
		ArrayList<String> Functions = getFunctions__wrappee__tModification();
		Functions.add("delete");
		return Functions;
	}

	

	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = getFunctions__wrappee__tDelete();
		Functions.add("show");
		return Functions;
	}

	

	@Override
	public int getID() {
		return 2;
	}

	
	public void createNew(Transaction transaction) throws SQLException {
		String stmt = "INSERT INTO transactions (description, amount, date, cid, aid, uid) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, transaction);
		ps.setInt(6, uid);
		db.runStmt(ps);
	}

	
	
	public void mod(Transaction transactionOld, Transaction transactionNew) throws SQLException {
		mod(transactionOld.getTid(), transactionNew);
	}

	
	
	public void mod(int oldtid, Transaction transaction) throws SQLException {
		String stmt = "UPDATE transactions SET description = ?, amount = ?, date = ?, cid = ?, aid = ? WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, transaction);
		ps.setInt(6, oldtid);
		db.runStmt(ps);
	}

	
	public void delete(Transaction transaction) throws SQLException {
		delete(transaction.getTid());
	}

	

	public void delete(int tid) throws SQLException {
		String stmt = "DELETE FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, tid);
	}

	
	public void show(int tid) throws SQLException {
		String stmt = "SELECT * FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, tid);
		// TODO
		db.runStmt(ps);
	}


}
