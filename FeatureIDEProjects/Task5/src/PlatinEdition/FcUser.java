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

	
	 private void  runFeature__wrappee__uInsertion  (int i) throws SQLException {
		int uid;
		Scanner uidInput;
		
		switch (i) {
		case 1:
			um.createNew(null);
			break;

		}
		runFeature__wrappee__Users(i);
	}

	
	 private void  runFeature__wrappee__uModification  (int i) throws SQLException {
		int uid;
		Scanner uidInput;

		switch (i) {
		case 2:
			um.mod(0, null);
			break;
		}
		runFeature__wrappee__uInsertion(i);
	}

	
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
		runFeature__wrappee__uModification(i);
	}


}
