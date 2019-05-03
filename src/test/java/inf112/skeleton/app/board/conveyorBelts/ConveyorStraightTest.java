package inf112.skeleton.app.board.conveyorBelts;

import inf112.skeleton.app.board.ConveyorBelts.ConveyorStraight;
import inf112.skeleton.app.util.Direction;
import org.junit.Before;
import org.junit.Test;
import static  org.junit.Assert.*;

public class ConveyorStraightTest {
    private ConveyorStraight testConveyorStraight;
    private int moveValue = 2;
    private Direction dir = Direction.NORTH;
    private int[] position = {3,4};

    @Before
    public void setup (){
        testConveyorStraight = new ConveyorStraight(dir, moveValue,position );

    }

    @Test
    public void directionTest () {
        assertEquals(dir,testConveyorStraight.getDirection());

    }

    @Test
    public void expresstypeTest(){
        assert testConveyorStraight.isExpressType();
    }
    @Test
    public void positionTest(){
        assertEquals(position,testConveyorStraight.getPosition());
    }
}
