import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {
	
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
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("modify");
		return Functions;
	}
}
