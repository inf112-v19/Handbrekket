package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.robot.IRobot;

/**
 *
 */
public interface IRepairSite {

    /**
     * @return sprite
     */
    public Sprite getSprite();

    /**
     * executes the repair-method in game
     *
     * @param robot the robot to be repaired
     */
    public void action(IRobot robot);

    /**
     * A method that updates the robot's archive location. If the robot is destroyed
     * before reaching another archive location, this is where it will reenter the race.
     *
     * @param robot
     * @return
     */
    void updateArchiveLocation(IRobot robot);
}

