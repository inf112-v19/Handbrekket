package inf112.skeleton.app;

import inf112.skeleton.app.board.Direction;
import inf112.skeleton.app.board.Square;
import org.junit.Test;

import org.junit.Assert;


public class squareTest {



    @Test
    public void squareIsEmpty () {
        Square sqaure = new Square(5,5);
        Assert.assertEquals(sqaure.doesTheSquareContainARobot(),null);

    }

    @Test
    public void squareContainsRobot () {
        Square sqaure = new Square(5,5);
        //Robot robot = new Robot();
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
