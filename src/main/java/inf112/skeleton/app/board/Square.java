package inf112.skeleton.app.board;

import inf112.skeleton.app.robot.Robot;

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


    public boolean hasSquareWalls(){

        return false;
    }


    public boolean hasSquareWall(Direction dir){
        return false;

    }

    //TODO: Change this to use a try statement or similar once it becomes appropriate
    public boolean putRobotInSquare(Robot robot) {
        this.robot = robot;
        return true;
    }
}