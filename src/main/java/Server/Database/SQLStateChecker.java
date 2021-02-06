package Server.Database;

import java.sql.SQLException;

public class SQLStateChecker {

    public static String TABLE_ALREADY_EXISTS = "X0Y32";

    public static boolean tableAlreadyExists(SQLException e) {
        return e.getSQLState().equals(TABLE_ALREADY_EXISTS);
    }
}
