import java.sql.*;
import java.util.Scanner;

public class SQLi_PreparedStatement_TypesTest {
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbConnection = System.getProperty("db.connection");
        // Can hold some value like
        // "jdbc:microsoft:sqlserver://<HOST>:1433,<UID>,<PWD>"
        return DriverManager.getConnection(dbConnection);
    }

    public void doUnsafe(char[] password) throws SQLException {
        Scanner sc = new Scanner(System.in);

        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String strVal = sc.nextLine();
            String sqlString = "select * from tbl where field=" + strVal;
            PreparedStatement stmt = connection.prepareStatement(sqlString);

            int intVal = sc.nextInt();
            sqlString = "select * from tbl where field=" + intVal;
            stmt = connection.prepareStatement(sqlString);

            Integer integerVal = sc.nextInt();
            sqlString = "select * from tbl where field=" + integerVal;
            stmt = connection.prepareStatement(sqlString);

            double dblVal = sc.nextDouble();
            sqlString = "select * from tbl where field=" + dblVal;
            stmt = connection.prepareStatement(sqlString);

            double doubleVal = sc.nextDouble();
            sqlString = "select * from tbl where field=" + doubleVal;
            stmt = connection.prepareStatement(sqlString);

            float fltVal = sc.nextFloat();
            sqlString = "select * from tbl where field=" + fltVal;
            stmt = connection.prepareStatement(sqlString);

            Float floatVal = sc.nextFloat();
            sqlString = "select * from tbl where field=" + floatVal;
            stmt = connection.prepareStatement(sqlString);

            boolean boolVal = sc.nextBoolean();
            sqlString = "select * from tbl where field=" + boolVal;
            stmt = connection.prepareStatement(sqlString);

            Boolean booleanVal = (Boolean) sc.nextBoolean();
            sqlString = "select * from tbl where field=" + booleanVal;
            stmt = connection.prepareStatement(sqlString);

        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
                // Forward to handler
            }
        }
    }
}