import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager{
	private int uid;
	private dbConnector db;
	private TransactionManager tm;

	public AccountManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
		this.tm = new TransactionManager(uid);
	}

	private PreparedStatement fillValues(PreparedStatement ps, Account account) throws SQLException {
		ps.setString(1, account.getAtitle());
		ps.setString(2, account.getAdescription());
		ps.setFloat(3, account.getAamount());
		return ps;
	}
}
