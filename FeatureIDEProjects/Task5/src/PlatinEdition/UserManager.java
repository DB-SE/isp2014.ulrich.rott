import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.ArrayList; 

public   class  UserManager {
	
	private int uid;

	
	private dbConnector db;

	

	public UserManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
	}

	

	private PreparedStatement fillValues(PreparedStatement ps, User user) throws SQLException {
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getRealname());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		return ps;
	}

	
	public void createNew(User user) throws SQLException {
		String stmt = "INSERT INTO users (username, realname, email, password) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, user);
		db.runStmt(ps);
	}

	
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

	
	public void delete(User user) throws SQLException {
		delete(user.getUid());
	}

	

	public void delete(int uid) throws SQLException {
		String stmt = "DELETE FROM users WHERE uid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, uid);
	}

	
	public void show(int uid) throws SQLException {
		String stmt = "SELECT * FROM users WHERE uid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, uid);
		// TODO
		db.runStmt(ps);
	}


}
