package functions;

import java.sql.SQLException;
import java.util.Scanner;

import features.AccountManager;
import interfaces.FunctionInterface;

public class FcAccount implements FunctionInterface {
	public AccountManager am;
	
	public FcAccount(AccountManager aminput){
		this.am = aminput;
	}

	@Override
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
		case 1:
			am.createNew(null);
			break;
		case 2:
			am.mod(0, null);
			break;
		case 3:
			am.transfer(null, null, 0, null);
			break;
		case 4:
			System.out.print("tid to delete: ");
			aidInput = new Scanner(System.in);
			aid = aidInput.nextInt();
	        aidInput.reset();			
			am.delete(aid);
			System.out.println("Account with aid:" + aid + "was deleted.");
			break;
		default:
			System.out.println("Option is not available!");
			break;
		}
	}
}
