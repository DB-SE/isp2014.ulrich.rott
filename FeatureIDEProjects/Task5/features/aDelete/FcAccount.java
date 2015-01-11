import java.sql.SQLException;
import java.util.Scanner;

public class FcAccount {
	public void runFeature(int i) throws SQLException {
		int aid;
		Scanner aidInput;
		
		switch (i) {
		case 4:
			System.out.print("tid to delete: ");
			aidInput = new Scanner(System.in);
			aid = aidInput.nextInt();
	        aidInput.reset();			
			am.delete(aid);
			System.out.println("Account with aid:" + aid + "was deleted.");
			break;
		}
		original(i);
	}
}
