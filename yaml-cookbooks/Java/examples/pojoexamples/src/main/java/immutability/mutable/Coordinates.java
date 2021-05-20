package immutability.mutable;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(){
        x=0;
        y=0;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void transform(int xAdjust, int yAdjust){
        this.x += xAdjust;
        this.y += yAdjust;
    }


/*
To make immutable:

- fields (member variables) should be final and set in the constructor
- remove the setMethods and use the constructor
- avoiding a default constructor and using constructor that sets the full object
- class should be final to prevent extension
- void methods should be converted into methods that return a new immutable object created with the 'side-effect' as the instantiated state
- method parameters should be final

Possibly:

- create types for X and Y coordinates to prevent mixup of params

*/

}
