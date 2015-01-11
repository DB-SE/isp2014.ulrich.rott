import java.sql.SQLException;
import java.util.ArrayList;

public class FcLogin implements FunctionInterface{
	private LoginManager Current; 
	
	public FcLogin(LoginManager LM){
		Current = LM;
	}

	@Override
	public void runFeature(int i) throws SQLException {
		switch (i) {
		case 0:
			Current.getID();
			break;
		case 1:
			Current.getStatus();
			break;
		}
	}
}
