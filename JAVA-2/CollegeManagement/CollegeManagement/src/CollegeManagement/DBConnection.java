package CollegeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/collegeManagement"; 
    static final String USER = "root"; 
    static final String PASS = "pemba143apple"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASS);
    }
}