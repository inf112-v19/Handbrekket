package inf112.skeleton.app;



import java.awt.*;

public class Square implements ISquare{

    private int length;
    private int width;
    private String state; //State -> empty or robot
    private boolean wall;

    public Square (int length, int width, String state, boolean wall) {
        this.length=length;
        this.width=width;
        this.state=state;
        this.wall=wall;
    }


    public IRobot getRobot() {
        if(this.state=="robot"){
            //return robotObjekt
        } else if (this.state=="empty"){
            return null;
        } else {
            System.err.println("Uknown state");
        }
        return null;
    }

    public boolean hasWalls(){
        return this.wall;

    }

    public boolean hasWall(int dir){


    }


}