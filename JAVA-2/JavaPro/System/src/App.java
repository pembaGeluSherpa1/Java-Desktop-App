import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world");
        String jdbcUrl = "jdbc:mysql://localhost:3308";
        String username= "root";
        String password = "";

        try{
            // load mysql jdbc driver (optional for modern version)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // connect to database
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);

            System.out.println("Connected to the database");
            
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
