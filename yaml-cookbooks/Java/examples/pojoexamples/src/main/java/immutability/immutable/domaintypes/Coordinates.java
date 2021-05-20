package immutability.immutable.domaintypes;

public final class Coordinates {

    private final XCoordinate x;
    private final YCoordinate y;

    private Coordinates(XCoordinate x, final YCoordinate y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates create(final XCoordinate xCoord, final YCoordinate yCoord) {
        return new Coordinates(xCoord, yCoord);
    }

    public Coordinates transform(final XCoordinate xAdjust, final YCoordinate yAdjust) {
        return new Coordinates(
                        XCoordinate.xCoordinate(
                                    this.x.getValue() + xAdjust.getValue()),
                        YCoordinate.yCoordinate(
                                    this.y.getValue() + yAdjust.getValue()));
    }

    public Integer getX() {
        return x.getValue();
    }

    public Integer getY() {
        return y.getValue();
    }
}
