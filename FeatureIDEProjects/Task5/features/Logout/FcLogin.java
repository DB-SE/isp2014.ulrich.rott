import java.sql.SQLException;
import java.util.ArrayList;

public class FcLogin {
	public void runFeature(int i) throws SQLException {
		switch (i) {
		case 3:
			Current.logout();
			break;
		}
		original(i);
	}
}
