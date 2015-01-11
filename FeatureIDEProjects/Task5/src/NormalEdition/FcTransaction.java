import java.sql.SQLException; 
import java.util.Scanner; 

public   class  FcTransaction  implements FunctionInterface {
	
	private TransactionManager tm;

	

	public FcTransaction(TransactionManager tminput) {
		this.tm = tminput;
	}

	

	
	 private void  runFeature__wrappee__Transaktion(int i) throws SQLException {
		int tid;
		switch (i) {
		default:
			System.out.println("Option is not available!");
			break;
		}
	}

	
	 private void  runFeature__wrappee__tInsertion  (int i) throws SQLException {
		int tid;
		switch (i) {
		case 1:
			tm.createNew(null);
			break;
		}
		runFeature__wrappee__Transaktion(i);
	}

	
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
		runFeature__wrappee__tInsertion(i);
	}


}
