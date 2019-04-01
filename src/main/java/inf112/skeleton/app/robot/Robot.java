package inf112.skeleton.app.robot;

import inf112.skeleton.app.board.Direction;

import java.awt.image.BufferedImage;


/**
 *
 * Creates a robot character to assign to a player.
 */
public class Robot implements IRobot{
    private Direction dir;
    private final int id;
    private int[] coordinate;
    private int[] backup;

    /**
     * Creates a robot using the coordinates and id supplied
     *
     * @param id the id of the robot
     * @param coordinate the coordinates the robot is on
     */
    public Robot(int id, int[] coordinate) {
        dir = Direction.SOUTH; //TODO: really shouldn't automatically be set to east (I think?)
        this.id = id;
        this.coordinate = coordinate;
        int[] backup = coordinate;
    }

    @Override
    public void rotate(Boolean rotateDirection) {
        if(rotateDirection)
            dir = dir.next();
        else
            dir = dir.previous();
    }

    @Override
    public Direction getDir() {
        return dir;
    }

    @Override
    public void setDir(Direction dirIn) {
        dir = dirIn;
    }

    @Override
    public int getID(){
        return this.id;
    }

    @Override
    public int[] getBackup() {
        return backup;
    }

    @Override
    public void setBackup(int[] backup) {
        this.backup = backup;
    }

    @Override
    public int[] getPosition() {
        return coordinate;
    }

    @Override
    public void setPosition(int[] position) {
        coordinate = position;
    }
}