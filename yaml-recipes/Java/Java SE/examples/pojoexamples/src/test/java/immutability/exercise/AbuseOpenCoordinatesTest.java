package immutability.exercise;

import immutability.mutable.OpenCoordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbuseOpenCoordinatesTest {

    /*
        This set of tests demonstrates how to 'abuse' the mutability.

        If you make the AbuseOpenCoordinates class immutable then the tests should fail.

     */

    @Test
    public void canAmendFields(){

        // to fix:
        // make fields final, so that they cannot be changed once set
        // and only st them during the creation of the object

        // create
        AbuseOpenCoordinates position = new AbuseOpenCoordinates();
        position.x = 3;
        position.y = 6;

        // allowing change after creation can put the object
        // into an invalid state
        position.x = -7;
        position.y = 11;

        Assertions.assertEquals(-7, position.x);
        Assertions.assertEquals(11, position.y);
    }

    @Test
    public void transformWillAmendTheData(){
        AbuseOpenCoordinates position = new AbuseOpenCoordinates();
        position.x = 1;
        position.y = 4;

        // if I can amend the data once created then we
        // can have concurrency or multi-threading issues
        position.transform(-1, -4);

        Assertions.assertEquals(0, position.x);
        Assertions.assertEquals(0, position.y);
    }

    @Test
    public void extendToChange(){

        // the ExtendedOpenCoordinates extends OpenCoordinates so could
        // be passed to any code expecting an OpenCoordinates object
        // but it has changed the functionality of the `transform`
        // method, so code depending on the OpenCoordinates implementation
        // of `transform` would fail
        AbuseOpenCoordinates position = new ExtendedOpenCoordinates();
        position.x = 1;
        position.y=4;

        position.transform(-1, -4);
        Assertions.assertEquals(-3, position.x);
        Assertions.assertEquals(3, position.y);

    }

    private class ExtendedOpenCoordinates extends AbuseOpenCoordinates {

        @Override
        public void transform(int yAdjust, int xAdjust){
            // this method override changed the param positions
            this.x += xAdjust;
            this.y += yAdjust;
        }
    }
}
