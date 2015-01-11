import java.sql.SQLException;
import java.util.Scanner;

public class FcUser implements FunctionInterface {
	private UserManager um;

	public FcUser(UserManager umInput) {
		this.um = umInput;
	}

	@Override
	public void runFeature(int i) throws SQLException {
		int uid;
		Scanner uidInput;

		switch (i) {
		default:
			System.out.println("Option is not available!");
		}
	}
}
