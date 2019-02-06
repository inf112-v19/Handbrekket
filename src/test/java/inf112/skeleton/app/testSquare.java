package inf112.skeleton.app;

import org.junit.Test;

import org.junit.Assert;

import inf112.skeleton.app.Square;



public class testSquare {



    @Test
    public void squareIsEmpty () {
        Square sqaure = new Square(5,5,"empty",true);
        Assert.assertEquals(sqaure.getRobot(),null);

    }

    @Test
    public void squareContainsRobot () {
        Square sqaure = new Square(5,5,"robot",false);
        //Robot robot = new Robot();
        //Assert.assertEquals(sqaure.getRobot(),robot);

    }

    @Test
    public void hasWalls(){
        Square square = new Square(5,5,"empty",true);
        //Assert.assertTrue(true);

    }

    @Test
    public void hasWallsWithDirection() {
        
    }
}
