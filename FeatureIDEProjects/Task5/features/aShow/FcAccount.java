import java.sql.SQLException;
import java.util.Scanner;

public class FcAccount implements FunctionInterface {
	public void runFeature(int i) throws SQLException {
		int aid;
		Scanner aidInput;

		switch (i) {
		case 0:
			System.out.print("tid to show: ");
			aidInput = new Scanner(System.in);
			aid = aidInput.nextInt();
			aidInput.reset();
			am.show(aid);
			break;
		}
		original(i);
	}
}
