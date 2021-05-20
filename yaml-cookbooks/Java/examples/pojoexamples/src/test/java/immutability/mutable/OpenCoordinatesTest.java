package immutability.mutable;

import immutability.mutable.Coordinates;
import immutability.mutable.OpenCoordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpenCoordinatesTest {

    // OpenCoordinates is a whole heap of wrong.
    // TODO: Fields should not be public
    // TODO: add getters for the field values
    // TODO: set the coordinate position when creating object
    // TODO: make transform return a new object

    @Test
    public void canRepositionCoords(){

        OpenCoordinates position = new OpenCoordinates();
        position.x = 3;
        position.y = 6;

        position.transform(-10, 5);

        Assertions.assertEquals(-7, position.x);
        Assertions.assertEquals(11, position.y);
    }

    @Test
    public void canTransformPositionWithoutMoving(){
        OpenCoordinates position = new OpenCoordinates();
        position.x = 1;
        position.y = 4;

        position.transform(0, 0);

        Assertions.assertEquals(1, position.x);
        Assertions.assertEquals(4, position.y);
    }

}
