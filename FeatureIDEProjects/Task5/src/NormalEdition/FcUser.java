import java.sql.SQLException; 
import java.util.Scanner; 

public   class  FcUser  implements FunctionInterface {
	
	private UserManager um;

	

	public FcUser(UserManager umInput) {
		this.um = umInput;
	}

	

	
	 private void  runFeature__wrappee__Users(int i) throws SQLException {
		int uid;
		Scanner uidInput;

		switch (i) {
		default:
			System.out.println("Option is not available!");
		}
	}

	
	public void runFeature(int i) throws SQLException {
		int uid;
		Scanner uidInput;
		
		switch (i) {
		case 1:
			um.createNew(null);
			break;

		}
		runFeature__wrappee__Users(i);
	}


}
