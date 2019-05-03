package inf112.skeleton.app.board.conveyorBelts;

import inf112.skeleton.app.board.ConveyorBelts.ConveyorCombine;
import inf112.skeleton.app.util.Direction;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConveyorCombineTest {
    private ConveyorCombine testConveyorCombine;
    private Direction dir = Direction.NORTH;
    private int moveValue = 2;
    private int[] position = {1, 2};
    private boolean RotationDirectionFromPreviousPosition = true;

    @Before
    public void setup() {
        testConveyorCombine = new ConveyorCombine(dir, moveValue, position);
    }

    public void positionTest(){
        assertEquals(position,testConveyorCombine.getPosition());
    }

    @Test
    public void expressTypeTest() {
        assert(testConveyorCombine.isExpressType());

    }
    @Test
    public void getRotationDirectionFromPreviousPositionTest(){
        int[] testPosition = new int[2];
        testPosition[0] = 2;
        testPosition[1] = 2;
        assert(testConveyorCombine.getRotationDirectionFromPreviousPosition(testPosition));

    }


}