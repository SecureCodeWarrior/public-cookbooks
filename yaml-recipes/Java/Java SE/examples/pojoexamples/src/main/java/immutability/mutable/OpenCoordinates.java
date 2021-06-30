package immutability.mutable;

/*
    This class represents a simpler mutable class.
 */
public class OpenCoordinates {

    public int x;
    public int y;

    public OpenCoordinates(){
        x=0;
        y=0;
    }

    public void transform(int xAdjust, int yAdjust){
        this.x+=xAdjust;
        this.y+=yAdjust;
    }


}
