import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager {
	private int uid;
	private dbConnector db;
	private TransactionManager tm;

	public void delete(Account account) throws SQLException {
		delete(account.getAid());
	}

	public void delete(int aid) throws SQLException {
		String stmt = "DELETE FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("delete");
		return Functions;
	}
}
