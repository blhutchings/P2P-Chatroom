package Server.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChatLogDB {

    public static void main(String[] args) throws SQLException {
        ChatLogDB log = new ChatLogDB();
    }

    public  final String JDBC_URL = "jdbc:derby:chatlog;create=true";
    private final Connection connection;

    public ChatLogDB() throws SQLException {
        this.connection = DriverManager.getConnection(JDBC_URL);
        System.out.println(createChatLogTable());
    }





    private boolean createChatLogTable() throws SQLException {
        boolean success = false;

        Statement statement = connection.createStatement();

        try {
            statement.execute("CREATE TABLE log0_db (" +
                    "messageNumber INT NOT NULL," +
                    "userID INT NOT NULL," +
                    "message VARCHAR(255) NOT NULL," +
                    "timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                    "PRIMARY KEY (messageNumber))");
            success = true;
        } catch (SQLException e) {
            //If the table already exists then all is good
            if (SQLStateChecker.tableAlreadyExists(e)){
                System.out.println("Table Already Exists");
                success = true;
            }
        }
        return success;
    }
}
