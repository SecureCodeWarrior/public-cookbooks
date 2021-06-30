package secureddb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecureDbApi {

    private final Connection dbConnection;
    Logger logger = Logger.getLogger(SecureDbApi.class.getName());

    public SecureDbApi(Connection connection) {
        this.dbConnection = connection;
    }

    public List<String> getTodosOfStatus(String status) {

        List<String> todos = new ArrayList<>();

        try {
            PreparedStatement stm = dbConnection.prepareStatement("SELECT description from todos where status= ?");
            stm.setString(1, status);
            ResultSet res = stm.executeQuery();

            while(res.next()){
                todos.add(res.getString("description"));
            }

            stm.close();

        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }

        return todos;
    }


    public List<String> getUserNotesForName(String name) {

        List<String> notes = new ArrayList<>();

        try {
            String sql = "SELECT notes from users where name= ?";

            PreparedStatement pstm = dbConnection.prepareStatement(sql);
            pstm.setString(1, name);
            ResultSet res = pstm.executeQuery();

            while(res.next()){
                notes.add(res.getString("notes"));
            }

            pstm.close();

        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }

        return notes;
    }
}
