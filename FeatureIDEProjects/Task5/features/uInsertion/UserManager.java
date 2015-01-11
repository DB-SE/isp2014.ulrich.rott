import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager {
	public void createNew(User user) throws SQLException {
		String stmt = "INSERT INTO users (username, realname, email, password) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, user);
		db.runStmt(ps);
	}
}
