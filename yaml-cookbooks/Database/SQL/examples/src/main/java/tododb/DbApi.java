package tododb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbApi {

    private final Connection dbConnection;
    Logger logger = Logger.getLogger(DbApi.class.getName());

    public DbApi(Connection connection) {
        this.dbConnection = connection;
    }

    public List<String> getTodosOfStatus(String status) {

        List<String> todos = new ArrayList<>();

        try {
            Statement stm = dbConnection.createStatement();
            ResultSet res = stm.executeQuery(
                    "SELECT description from todos where status=" + status);

            while(res.next()){
                todos.add(res.getString("description"));
            }

            stm.close();

        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }

        return todos;
    }

}
