import java.sql.SQLException;
import java.util.Scanner;

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
		default:
			System.out.println("Option is not available!");
			break;
		}
	}
}
