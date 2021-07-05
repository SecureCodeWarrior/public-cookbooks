import java.sql.*;
import java.util.Scanner;

public class SQLi_Statement_Test {
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbConnection = System.getProperty("db.connection");
        // Can hold some value like
        // "jdbc:microsoft:sqlserver://<HOST>:1433,<UID>,<PWD>"
        return DriverManager.getConnection(dbConnection);
    }

    public void doUnsafe() throws SQLException {
        Scanner sc = new Scanner(System.in);

        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new SQLException("No connection could be made");
            }
            String strVal = sc.nextLine();
            String sqlString = "select * from tbl where field=" + strVal;
            Statement stmt = connection.createStatement();
            stmt.executeQuery(sqlString);
            stmt.execute(sqlString);
            stmt.executeUpdate(sqlString);
            stmt.executeLargeUpdate(sqlString);
            stmt.executeBatch();
            stmt.executeLargeBatch();

            int intVal = sc.nextInt();
            sqlString = "select * from tbl where field=" + intVal;
            stmt = connection.createStatement();
            stmt.executeQuery(sqlString);
        }
        // Forward to handler
    }
}