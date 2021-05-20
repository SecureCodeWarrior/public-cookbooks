package modifier.visibility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Junit5VisibilityTest {

    @Test
    void thisDoesNotNeedToBePublic(){
        Assertions.assertTrue(true);
    }

    @Test
    void thisDoesNotNeedToBePublicEither(){
        Assertions.assertTrue(true);
    }
}
