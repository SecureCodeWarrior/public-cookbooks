package immutability.immutable;

/*
    This class represents a simpler mutable class.
 */
public final class OpenCoordinates {

    private final int x;
    private final int y;

    private OpenCoordinates(final int x, final int y ){
        this.x=x;
        this.y=y;
    }

    public static OpenCoordinates create(final int x, final int y ){
        return new OpenCoordinates(x, y );
    }

    public OpenCoordinates transform(int xAdjust, int yAdjust){
        return new OpenCoordinates(this.x + xAdjust, this.y + yAdjust);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
