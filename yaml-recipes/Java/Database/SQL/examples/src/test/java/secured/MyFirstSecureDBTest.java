package secured;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secureddb.MySecureDB;
import secureddb.SecureDbApi;
import tododb.DbApi;
import tododb.MyDB;

import java.sql.SQLException;
import java.util.List;

public class MyFirstSecureDBTest {

    static SecureDbApi myDB;

    @BeforeAll
    static void setupDB(){
        myDB = new SecureDbApi(new MySecureDB().create());
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

        List<String> descriptions = myDB.getTodosOfStatus(doneStatus);

        Assertions.assertEquals(0, descriptions.size());
    }
}