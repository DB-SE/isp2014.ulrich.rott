import java.sql.SQLException; 
import java.util.Scanner; 

public   class  FcAccount  implements FunctionInterface {
	
	public AccountManager am;

	
	
	public FcAccount(AccountManager aminput){
		this.am = aminput;
	}

	
	 private void  runFeature__wrappee__aInsertion  (int i) throws SQLException {
		int aid;
		Scanner aidInput;
		
		switch (i) {
		case 1:
			am.createNew(null);
			break;
		}
	}

	
	 private void  runFeature__wrappee__aModification  (int i) throws SQLException {
		int aid;
		Scanner aidInput;
		
		switch (i) {
		case 2:
			am.mod(0, null);
			break;
		}
		runFeature__wrappee__aInsertion(i);
	}

	
	 private void  runFeature__wrappee__aDelete  (int i) throws SQLException {
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
		runFeature__wrappee__aModification(i);
	}

	
	 private void  runFeature__wrappee__aTransfer  (int i) throws SQLException {
		int aid;
		Scanner aidInput;

		switch (i) {
		case 3:
			am.transfer(null, null, 0, null);
			break;
		}
		runFeature__wrappee__aDelete(i);
	}

	
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
		runFeature__wrappee__aTransfer(i);
	}


}
