package functions;
import java.sql.SQLException;
import java.util.ArrayList;

import features.*;
import interfaces.*;

public class FcLogin implements FunctionInterface{
	private LoginManager Current; 
	
	public FcLogin(LoginManager LM){
		Current = LM;
	}

	@Override
	public void runFeature(int i) throws SQLException {
		switch (i) {
		case 0:
			Current.login();
			break;
		case 1:
			Current.logout();
			break;
		case 2:
			Current.getID();
			break;
		case 3:
			Current.getStatus();
			break;
		default:
			System.out.println("Option is not available!");
			break;
		}
		
	}
}
