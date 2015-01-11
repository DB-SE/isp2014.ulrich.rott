import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {
	public void show(int tid) throws SQLException {
		String stmt = "SELECT * FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, tid);
		// TODO
		db.runStmt(ps);
	}
}
