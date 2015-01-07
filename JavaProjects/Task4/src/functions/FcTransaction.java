package functions;

import java.sql.SQLException;
import java.util.Scanner;

import features.TransactionManager;
import interfaces.FunctionInterface;

public class FcTransaction implements FunctionInterface{
	private TransactionManager tm;
	
	public FcTransaction(TransactionManager tminput){
		this.tm = tminput; 
	}
	
	@Override
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
		case 1:
			tm.createNew(null);
			break;
		case 2:
			tm.mod(0, null);
			break;
		case 3:
			System.out.print("tid to delete: ");
			Scanner userInput = new Scanner(System.in);
			tid = userInput.nextInt();
	        userInput.reset();
			tm.delete(tid);
			System.out.println("Transaction with tid:" + tid + "was deleted.");
		default:
			System.out.println("Option is not available!");
			break;
		}	
	}
}
