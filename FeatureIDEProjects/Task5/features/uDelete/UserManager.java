import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserManager {
	public void delete(User user) throws SQLException {
		delete(user.getUid());
	}

	public void delete(int uid) throws SQLException {
		String stmt = "DELETE FROM users WHERE uid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, uid);
	}
	
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = original();
		Functions.add("delete");
		return Functions;
	}
}
