package inf112.skeleton.app.board.conveyorBelts;

import inf112.skeleton.app.board.IProgramRegister;
import inf112.skeleton.app.board.ProgramRegister;
import inf112.skeleton.app.robot.*;
import inf112.skeleton.app.robot.ai.IAI;
import inf112.skeleton.app.robot.ai.SimpleAI;
import inf112.skeleton.app.robot.ai.SimpleBraveAI;
import org.junit.Test;
import inf112.skeleton.app.robot.Robot;


public class AITest {

    private int [] position = {2,3};
    private IRobot robot = new Robot(2,position);
    private IAI simpleComputer = new SimpleAI();
    private IAI advancedComputer = new SimpleBraveAI();
    private IProgramRegister programRegister = new ProgramRegister(robot,false);

    @Test
    public void decideIfSimplePowerDownTest () {


    }

    @Test
    public void activateCardsTest () {

    }

    @Test
    public void decideIfAdvancedPowerDownTest () {

        advancedComputer.decideIfPowerDown(programRegister);


    }
}
