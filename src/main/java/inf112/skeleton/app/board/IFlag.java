package inf112.skeleton.app.board;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.skeleton.app.robot.IRobot;

public interface IFlag {

    /**
     * Gives the number of the flag the robot has reached
     * @return flagNumber
     */
    int getFlagNumber();


    /**
     *
     * @return sprite
     */
    Sprite getSprite();


    /**
     * A method that updates the robot's archive location. If the robot is destroyed
     * before reaching another archive location, this is where it will reenter the race.
     * @param robot
     * @return
     */
    void updateArchiveLocation(IRobot robot);
}
