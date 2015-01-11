import java.sql.SQLException;
import java.util.Scanner;

public class FcUser {
	public void runFeature(int i) throws SQLException {
		int uid;
		Scanner uidInput;
		
		switch (i) {
		case 3:
			System.out.print("tid to delete: ");
			uidInput = new Scanner(System.in);
			uid = uidInput.nextInt();
	        uidInput.reset();			
			System.out.println("User with uid:" + uid + "was deleted.");
			um.delete(uid);
			break;
		}
		original(i);
	}
}
