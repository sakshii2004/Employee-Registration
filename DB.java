package lab_8_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	// setting database credentials
    private static final String URL = "jdbc:mariadb://localhost:3306/wisteria";
    private static final String USERNAME = "sakshi";
    private static final String PASSWORD = "sakshi123";

    // Connection variable initialization
    protected static Connection con = null;
       
    // creating connection
    public DB() throws SQLException {
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
