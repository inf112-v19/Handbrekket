package inf112.skeleton.app;



import java.awt.*;

public class Square implements ISquare{

    private int length;
    private int width;
    private String state; //State -> empty or robot
    private boolean wall;

    /**
     * Square Constructor
    @param xCoordinate
     @param yCoordinate
     @param state
     @param wall
     */

    public Square (int xCoordinate, int yCoordinate, String state, boolean wall) {
        this.length=xCoordinate;
        this.width=yCoordinate;
        this.state=state;
        this.wall=wall;

        //TODO: put Robot in Square?
    }


    /**
     *
     * @return 
     */
    public IRobot getRobot() {
        if(this.state=="robot"){
            //return robotObjekt
        } else if (this.state=="empty"){
            return null;
        } else {
            System.err.println("Unknown state");
        }
        return null;
    }

    public boolean hasWalls(){
        return this.wall;

    }

    public boolean hasWall(Direction dir){
        return this.wall;

    }


}