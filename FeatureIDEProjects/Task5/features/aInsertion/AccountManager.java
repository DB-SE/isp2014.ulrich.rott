import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager {
	public void createNew(Account account) throws SQLException {
		String stmt = "INSERT INTO accounts (atitle, adescription, aamount, uid) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, uid);
		db.runStmt(ps);
	}
}
