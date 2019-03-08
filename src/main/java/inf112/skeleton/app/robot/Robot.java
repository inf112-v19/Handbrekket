package inf112.skeleton.app.robot;

import inf112.skeleton.app.board.Direction;

import java.awt.image.BufferedImage;


/**
 *
 * Creates a robot character to assign to a player.
 */
public class Robot implements IRobot{
    private int hp;
    private Direction dir;
    private final int id;
    private BufferedImage image;
    private int lives;
    private boolean powerDown;
    /**
     * Gets a name from the Robotbuilder class and creates the robot character with that name.
     * @param
     * @param
     */
    public Robot(int id) {
        dir = Direction.EAST;
        hp = 0;
        lives = 3;
        this.id = id;
        powerDown = false;
    }

    /**
     * Returns current lives
     *
     * @return Lives
     */
    @Override
    public int getLives() {
        return lives;
    }

    /**
     * Decrease lives by one
     */
    @Override
    public void decreaseLives() {
        lives --;
    }

    /**
     * Returns current hitpoints
     *
     * @return HP
     */
    //
    public int getHP() {
        return hp;
    }

    @Override
    public void powerDown() {
        powerDown = true;
    }

    @Override
    public boolean isPoweredDown() {
        return powerDown;
    }

    public Direction getDir() {
        return dir;
    }

    public Robot getRobot(){
        return Robot.this;
    }

    public String printRobot () {
        return "X_R";
    }

    public void setDir(Direction dirIn) {
        dir = dirIn;
    }

    public void move() {

    }

    @Override
    public int setHP(int HP) {
        hp = HP;
        return hp;
    }

    public int changeHP(int HP) {
        hp+=HP;
        if(hp < 0)
            hp=0;
        return hp;
    }

    public int getID(){
        return this.id;
    }
}