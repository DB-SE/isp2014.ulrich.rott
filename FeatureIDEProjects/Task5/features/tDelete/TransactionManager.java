import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {
	public void delete(Transaction transaction) throws SQLException {
		delete(transaction.getTid());
	}

	public void delete(int tid) throws SQLException {
		String stmt = "DELETE FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, tid);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("delete");
		return Functions;
	}
}
