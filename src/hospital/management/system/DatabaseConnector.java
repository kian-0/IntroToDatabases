package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection getConnection(String username, String password) throws SQLException {
        // JDBC URL
        String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
        
        // Establish the connection
        return DriverManager.getConnection(url, username, password);
    }
}
