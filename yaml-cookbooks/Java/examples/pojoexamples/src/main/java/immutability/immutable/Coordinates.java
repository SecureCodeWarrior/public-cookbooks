package immutability.immutable;

public final class Coordinates {

    private final int x;
    private final int y;

    private Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates create(final int x, final int y) {
        return new Coordinates(x, y);
    }

    public Coordinates transform(final int xAdjust, final int yAdjust) {
        return new Coordinates(this.x + xAdjust, this.y + yAdjust);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
