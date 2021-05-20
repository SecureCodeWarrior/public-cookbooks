package logging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SysOutTest {


    // todo: should really use a logger
    @Test
    void logSomeOutputAsWeTest(){

        System.out.println("Go for launch");

        String countdown = getCountdownString();

        Assertions.assertEquals(
                "10, 9, 8, 7, 6, 5, 4, 3, 2, 1",
                countdown);

        System.out.println("Blast Off");

    }

    private String getCountdownString() {

        String output = "";
        String prefix="";

        for(int countdown = 10; countdown > 0; countdown-- ){

            output = output + prefix + countdown;

            System.out.println(output);

            prefix=", ";
        }

        System.out.println(output);

        return output;
    }
}
