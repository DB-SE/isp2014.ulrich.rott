import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager {
	public void mod(Account accountOld, Account accountNew) throws SQLException {
		mod(accountOld.getAid(), accountNew);
	}

	public void mod(int aidOld, Account account) throws SQLException {
		String stmt = "UPDATE accounts SET atitle = ?, adescription = ?, aamount = ? WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, aidOld);
		db.runStmt(ps);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("modify");
		return Functions;
	}
}
