import java.sql.SQLException;
import java.util.Scanner;

public class FcTransaction {
	public void runFeature(int i) throws SQLException {
		int tid;
		switch (i) {
		case 0:
			System.out.print("tid to show: ");
			Scanner tidInput = new Scanner(System.in);
			tid = tidInput.nextInt();
	        tidInput.reset();			
			tm.show(tid);
			break;
			}
		original(i);
	}
}
