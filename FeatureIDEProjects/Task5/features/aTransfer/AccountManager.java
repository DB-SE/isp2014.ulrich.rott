import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager {
	public void transfer(Account accountFrom, Account accountTo, float value, Date date) throws SQLException {
		String description = "Transfer from" + accountFrom.getAdescription() + "  To " + accountTo.getAdescription();
		Transaction ta1 = new Transaction(description, value * (-1), date, uid, uid, uid);
		Transaction ta2 = new Transaction(description, value, date, uid, uid, uid);
		tm.createNew(ta1);
		tm.createNew(ta2);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("transfer");
		return Functions;
	}
}
