package inf112.skeleton.app.board;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.game.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;


public class RepairSite implements IRepairSite {

    private Game game;
    private IRobot robot;
    public int x;
    public int y;
    Sprite sprite;


    public RepairSite(RectangleMapObject repair, TiledMap map){
        x = (int) repair.getRectangle().getX();
        y = (int) repair.getRectangle().getY();

        Texture texture = new Texture(".png");
        sprite = new Sprite(texture);
        sprite.setSize(5, 5);
    }
    @Override
    public Sprite getSprite() {
        sprite.setX(x);
        sprite.setY(y);
        return sprite;
    }

    @Override
    public void action(IRobot robot) {
        game.repair(robot);
    }

    @Override
    public void updateArchiveLocation(IRobot robot) {
        int[] backup = new int[2];
        backup[0] = x;
        backup[1] = y;
        robot.setBackup(backup);
    }
}
