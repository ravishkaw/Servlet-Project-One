package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/projectdb1?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "";
    private static final String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    public Connection getDatabaseConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return connection;
    }
}
