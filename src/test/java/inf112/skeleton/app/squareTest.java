package inf112.skeleton.app;

<<<<<<< Updated upstream
import inf112.skeleton.app.board.*;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;
=======
import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Square;
>>>>>>> Stashed changes
import org.junit.Test;

import org.junit.Assert;


public class squareTest {



    @Test
    public void squareIsEmptyTest () {
        Square sqaure = new Square(5,5);
        Assert.assertEquals(sqaure.doesTheSquareContainARobot(),null);

    }

    @Test
    public void squareContainsRobotTest () {
        ISquare squaren= new Square(5,5);
        IRobot robot = new Robot()



            @Override
            public boolean hasSquareWall(Direction dir) {
                return false;
            }

            @Override
            public boolean hasSquareWalls() {
                return false;
            }

            @Override
            public boolean putRobotInSquare(Robot robot) {
                return false;
            }
        }
        //Assert.assertEquals(sqaure.doesTheSquareContainsaRobot(),robot);

    }

    @Test
    public void hasWalls(){
        Square square = new Square(5,5);
        //Assert.assertTrue(true);

    }

    @Test
    public void hasWallsWithDirection(Direction direction) {
        Square square = new Square(5,5);

        
    }
}
