import java.sql.SQLException;
import java.util.Scanner;

public class FcTransaction implements FunctionInterface {
	private TransactionManager tm;

	public FcTransaction(TransactionManager tminput) {
		this.tm = tminput;
	}

	@Override
	public void runFeature(int i) throws SQLException {
		int tid;
		switch (i) {
		default:
			System.out.println("Option is not available!");
			break;
		}
	}
}
