package annotations.avoidingreason;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/*
    Try This...

    Instead of a method called `SKIPTHIScanWeAddTwoNumbers`

    We want:

    - a method called `canWeAddTwoNumbers`
    - an `@Test` annotation on the method
    - and an `@Disabled` annotation on the method


    Create a recipe:

    - Which finds all `SKIPTHIS.*` methods.
    - With an associated quick fix which amends
    the method name, and adds the annotations.

 */

class SkipThisTest {

    void SKIPTHIScanWeAddTwoNumbers(){
        Assertions.fail("this test was skipped and should not run");
    }

}


