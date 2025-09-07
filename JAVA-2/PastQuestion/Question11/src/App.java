import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
// Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB name
        String username = "root"; // Replace with your DB username
        String password = "your_password"; // Replace with your DB password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(url, username, password);

            // Create statement
            stmt = conn.createStatement();

            // Execute query
            String query = "SELECT * FROM students";
            rs = stmt.executeQuery(query);

            // Display results
            System.out.println("ID\tName\t\tEmail");
            System.out.println("-------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }    }
