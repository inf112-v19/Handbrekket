package inf112.skeleton.app;

public class Square implements ISquare{

    private int xCoordinate;
    private int yCoordinate;
    private Robot robot=new Robot(5);

    public Square (int xCoordinate, int yCoordinate) {
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
    }

    public boolean doesTheSquareContainARobot() {
        if(Square.this.equals(robot.getRobot())){
            return true;
        } else if (!Square.this.equals(robot.getRobot())){
            return false;
        } else {
            System.err.println("Unknown state");
            return false;
        }

    }

    public String printSquare () {

        if(doesTheSquareContainARobot()){
            return robot.printRobot();
        } else {
            return "X";
        }
    }


    public boolean hasSquareWalls(){

        return false;
    }


    public boolean hasSquareWall(Direction dir){
        return false;

    }

    //TODO: put Robot in Square?   
    public void putRobotInSquare () {
                
    }


}