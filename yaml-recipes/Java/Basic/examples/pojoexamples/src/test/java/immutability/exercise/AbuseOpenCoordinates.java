package immutability.exercise;

/*
    This class represents a simpler mutable class.
 */
public class AbuseOpenCoordinates {

    public int x;
    public int y;

    public AbuseOpenCoordinates(){
        x=0;
        y=0;
    }

    public void transform( int xAdjust, int yAdjust){
        this.x+=xAdjust;
        this.y+=yAdjust;
    }


}
