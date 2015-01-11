import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager {
	public void show(int aid) throws SQLException {
		String stmt = "SELECT * FROM accounts WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
		// TODO
		db.runStmt(ps);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("show");
		return Functions;
	}
}
