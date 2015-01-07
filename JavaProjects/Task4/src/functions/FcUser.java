package functions;

import java.sql.SQLException;
import java.util.Scanner;

import features.UserManager;
import interfaces.FunctionInterface;

public class FcUser implements FunctionInterface{
	private UserManager um;
	
	public FcUser(UserManager umInput){
		this.um = umInput;
	}

	@Override
	public void runFeature(int i) throws SQLException {
		int uid;
		Scanner uidInput;
		
		switch (i) {
		case 0:
			System.out.print("tid to show: ");
			uidInput = new Scanner(System.in);
			uid = uidInput.nextInt();
	        uidInput.reset();			
			um.show(uid);
			break;
		case 1:
			um.createNew(null);
			break;
		case 2:
			um.mod(0, null);
			break;
		case 3:
			System.out.print("tid to delete: ");
			uidInput = new Scanner(System.in);
			uid = uidInput.nextInt();
	        uidInput.reset();			
			System.out.println("User with uid:" + uid + "was deleted.");
			um.delete(uid);
			break;
		default:
			System.out.println("Option is not available!");
		}
	}
}
