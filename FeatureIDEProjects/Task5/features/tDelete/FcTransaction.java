import java.sql.SQLException;
import java.util.Scanner;

public class FcTransaction {
	public void runFeature(int i) throws SQLException {
		int tid;
		switch (i) {
		case 3:
			System.out.print("tid to delete: ");
			Scanner userInput = new Scanner(System.in);
			tid = userInput.nextInt();
			userInput.reset();
			tm.delete(tid);
			System.out.println("Transaction with tid:" + tid + "was deleted.");
		}
		original(i);
	}
}
