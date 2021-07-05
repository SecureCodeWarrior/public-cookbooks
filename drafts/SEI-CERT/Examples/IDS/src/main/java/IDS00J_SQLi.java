import java.sql.*;

public class IDS00J_SQLi {
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        String dbConnection = System.getProperty("db.connection");
        // Can hold some value like
        // "jdbc:microsoft:sqlserver://<HOST>:1433,<UID>,<PWD>"
        return DriverManager.getConnection(dbConnection);
    }

    String hashPassword(char[] password) {
        // Create hash of password
        return "hash";
    }

    public void doPrivilegedActionUnsafe(String username, char[] password)
            throws SQLException {
        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String pwd = hashPassword(password);

            // Untrusted data used in query
            String sqlString = "SELECT * FROM db_user WHERE username = '"
                    + username + "' AND password = '" + pwd + "'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);

            // Bad use of preparedStatement
            String sqlString2 = "select * from db_user where username=" +
                    username + " and password =" + pwd;
            PreparedStatement stmt2 = connection.prepareStatement(sqlString2);
            ResultSet rs2 = stmt2.executeQuery();

            if (!rs.next()) {
                throw new SecurityException(
                        "User name or password incorrect"
                );
            }

            // Authenticated; proceed
        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
                // Forward to handler
            }
        }
    }

    public void doPrivilegedActionSafe(
            String username, char[] password
    ) throws SQLException {
        Connection connection = getConnection();
        if (connection == null) {
            // Handle error
        }
        try {
            String pwd = hashPassword(password);

            // Validate username length
            if (username.length() > 8) {
                // Handle error
            }

            String sqlString =
                    "select * from db_user where username=? and password=?";
            PreparedStatement stmt = connection.prepareStatement(sqlString);
            stmt.setString(1, username);
            stmt.setString(2, pwd);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                throw new SecurityException("User name or password incorrect");
            }

            // Authenticated; proceed
        } finally {
            try {
                connection.close();
            } catch (SQLException x) {
                // Forward to handler
            }
        }
    }
}