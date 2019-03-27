package inf112.skeleton.app.board;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.robot.IRobot;



public class Flag implements IFlag {

    public int flagNumber;
    public int y;
    public int x;
    Sprite sprite;

    /**
     * @param flag
     * @param map
     */
    public Flag(RectangleMapObject flag, TiledMap map) {
        x = (int) flag.getRectangle().getX();
        y = (int) flag.getRectangle().getY();

        Texture texture = new Texture("flag.png");
        sprite = new Sprite(texture);
        sprite.setSize(5, 5);
    }

    @Override
    public int getFlagNumber() {
        return flagNumber;
    }

    @Override
    public Sprite getSprite() {
        sprite.setX(x);
        sprite.setY(y);
        return sprite;
    }

    @Override
    public void updateArchiveLocation(IRobot robot) {
        int[] backup = new int[2];
        backup[0] = x;
        backup[1] = y;
        robot.setBackup(backup);
    }
}







