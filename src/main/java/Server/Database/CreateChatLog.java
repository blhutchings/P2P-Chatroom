package Server.Database;


import java.sql.*;

public class CreateChatLog {

    public static String namedb;
    public static final String JDBC_URL = "jdbc:derby:chatlog;create=true";
    public static final Connection connection = null;

    public void create() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL);

    }

    /*
    public CreateChatLog() throws SQLException {
        connection = DriverManager.getConnection(JDBC_URL);
        Statement statement = con.createStatement();

        /*
        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            String userData = "";
                for (int i = 1; i <= 2; i++) {
                    userData += result.getString(i) + ":";
                }
            System.out.println(userData);
        }


         */

        //con.createStatement().execute("INSERT INTO users VALUES (69,'HELLO MY NAME IS TOM')");
         /*
        con.createStatement().execute("CREATE TABLE users (" +
                "UserID int," +
                "Message varchar(255))");


        con.createStatement().execute("INSERT INTO users (UserID, Message)" +
                "VALUES (0,'HELLO MY NAMES TOM')");

        ResultSet result = con.createStatement().executeQuery("SELECT * FROM users");
        System.out.println(result.getInt("UserID"));
        result.close();
                 */
    }
