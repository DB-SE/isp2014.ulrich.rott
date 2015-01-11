import java.sql.SQLException; 
import java.util.ArrayList; 

public   class  FcLogin  implements FunctionInterface {
	
	private LoginManager Current;

	 
	
	public FcLogin(LoginManager LM){
		Current = LM;
	}

	

	
	 private void  runFeature__wrappee__Session(int i) throws SQLException {
		switch (i) {
		case 0:
			Current.getID();
			break;
		case 1:
			Current.getStatus();
			break;
		}
	}

	
	 private void  runFeature__wrappee__Login  (int i) throws SQLException {
		switch (i) {
		case 2:
			Current.login();
			break;
		}
		runFeature__wrappee__Session(i);
	}

	
	public void runFeature(int i) throws SQLException {
		switch (i) {
		case 3:
			Current.logout();
			break;
		}
		runFeature__wrappee__Login(i);
	}


}
