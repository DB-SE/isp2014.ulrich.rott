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
		runFeature__wrappee__aInsertion(i);
	}


}
