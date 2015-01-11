import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager {
	public void mod(User userOld, User userNew) throws SQLException {
		mod(userOld.getUid(), userNew);
	}

	public void mod(int uidOld, User userNew) throws SQLException {
		String stmt = "UPDATE users SET username = ?, realname = ?, email = ?, password = ? WHERE uid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, userNew);
		ps.setInt(5, uidOld);
		db.runStmt(ps);
	}
}
