package sqlinjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tododb.DbApi;
import tododb.MyDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyFirstDBTest {

    static DbApi myDB;

    @BeforeAll
    static void setupDB(){
        myDB = new DbApi(new MyDB().create());
    }

    @Test
    void myFirstSelect() throws SQLException {

        String doneStatus = "1";
        List<String> descriptions = myDB.getTodosOfStatus(doneStatus);

        Assertions.assertEquals(1, descriptions.size());
        Assertions.assertEquals("I did that activity", descriptions.get(0));
    }

    @Test
    void myFirstSQLInjection() throws SQLException {

        // get the admin user instead
        String doneStatus = "-1 UNION SELECT name || '~' || password as description from users";

        // TODO: fix the SQL Injection issue in the DBApi
        List<String> descriptions = myDB.getTodosOfStatus(doneStatus);

        Assertions.assertEquals(2, descriptions.size());
        Assertions.assertEquals("admin~root", descriptions.get(0));
        Assertions.assertEquals("bob~dobbs", descriptions.get(1));

    }
}
