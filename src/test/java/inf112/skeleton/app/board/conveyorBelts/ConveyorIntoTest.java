package inf112.skeleton.app.board.conveyorBelts;

import ...
import inf112.skeleton.app.board.ConveyorBelts.ConveyorInto;
import inf112.skeleton.app.board.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConveyorIntoTest {
    private ConveyorInto testConveyorInto ;
    private int moveValue = 1;
    private Direction dir = Direction.NORTH;
    private int[] position = {1,2};
    private boolean turnDirection;
    private boolean shouldRotate;


    @Before
    public void setup (){

        testConveyorInto = new ConveyorInto(dir,moveValue,position,turnDirection);
    }

    @Test
    public void DirectionTest () {
        assertEquals(dir, testConveyorInto.getDirection());
    }

    @Test
    public void positionTest(){
        assertEquals(position,testConveyorInto.getPosition());
    }


    @Test
    public void turnDirectionTest(){
        assert(testConveyorInto.getTurnDirection());


    }
    @Test
    public void expresstypeTest(){assert(testConveyorInto.isExpressType());

    }
    @Test
    public void shouldrotateTes() {
        assert (testConveyorInto.shouldRotate());
    }

}
