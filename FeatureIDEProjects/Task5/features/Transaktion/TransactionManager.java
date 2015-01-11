import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager implements FeatureInterface {
	private int uid;
	private dbConnector db;

	public TransactionManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
	}

	private PreparedStatement fillValues(PreparedStatement ps, Transaction transaction) throws SQLException {
		ps.setString(1, transaction.getDescription());
		ps.setFloat(2, transaction.getAmount());
		ps.setDate(3, transaction.getDate());
		ps.setInt(4, transaction.getCid());
		ps.setInt(5, transaction.getAid());
		return ps;
	}

	@Override
	public String getTitle() {
		return "TransactionsManager";
	}

	@Override
	public String getDescription() {
		return "Manager of the Transactions";
	}

	@Override
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("show");
		Functions.add("create");
		Functions.add("modify");
		Functions.add("delete");
		return Functions;
	}

	@Override
	public int getID() {
		return 2;
	}
}
