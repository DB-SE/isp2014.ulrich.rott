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

	

	@Override
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("show");
		Functions.add("create");
		Functions.add("modify");
		Functions.add("delete");
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


}
