import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {
	public void createNew(Transaction transaction) throws SQLException {
		String stmt = "INSERT INTO transactions (description, amount, date, cid, aid, uid) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, transaction);
		ps.setInt(6, uid);
		db.runStmt(ps);
	}
}
