package objects;

import settings.VariablesConst;

import java.sql.*;

public class dbConnector {
    private Connection con;
    private Statement st;

    private String url;
    private String user;
    private String password;

    public dbConnector() {
        VariablesConst constants = new VariablesConst();
        url = constants.getUrl();
        user = constants.getUser();
        password = constants.getPassword();

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (SQLException ex) {

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {

            }
        }

    }

    public Connection getConnection() {
        return this.con;
    }

    public ResultSet runStmt(PreparedStatement ps) {
        ResultSet result = null;

        try {
            result = ps.executeQuery();

        } catch (SQLException ex) {

        }

        return result;
    }

}
