package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateChatLog {

    public static final String JDBC_URL = "jdbc:derby:testdb;create=true";


    public CreateChatLog() throws SQLException {
        Connection con = DriverManager.getConnection(JDBC_URL);
        System.out.println("Connected to derby");
    }
}
