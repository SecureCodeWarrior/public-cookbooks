package immutability.immutable.domaintypes;

import immutability.immutable.domaintypes.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DomainCoordinatesTest {

    @Test
    public void canRepositionCoords(){

        Coordinates startPosition = Coordinates.create(
                                                XCoordinate.xCoordinate(3),
                                                YCoordinate.yCoordinate(6));

        Coordinates endPosition = startPosition.transform(
                                        XCoordinate.xCoordinate(-10),
                                        YCoordinate.yCoordinate(5));

        Assertions.assertEquals(-7, endPosition.getX());
        Assertions.assertEquals(11, endPosition.getY());
    }

    @Test
    public void canTransformPositionWithoutMoving(){
        Coordinates startPosition = Coordinates.create(
                                        XCoordinate.xCoordinate(1),
                                        YCoordinate.yCoordinate(4));
        Coordinates endPosition = startPosition.transform(
                                            XCoordinate.xCoordinate(0),
                                            YCoordinate.yCoordinate(0));

        Assertions.assertEquals(startPosition.getX(), endPosition.getX());
        Assertions.assertEquals(startPosition.getY(), endPosition.getY());
        Assertions.assertNotEquals(startPosition, endPosition);
    }

}
