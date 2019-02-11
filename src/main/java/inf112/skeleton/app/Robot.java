package inf112.skeleton.app;

import javax.imageio.ImageIO;
import java.awt.*;
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

    /**
     * Gets a name from the Robotbuilder class and creates the robot character with that name.
     * @param name The name of the robot character.
     * @param color The color associated with the robot (for prints in the console etc.).
     */
    public Robot(int id) {
        dir = Direction.EAST;
        hp = 1;
        this.id = id;
        /*
        switch (id) {
            case 1 :
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/case1.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("robots/case1.png could not be read");
                }
                break;
            case 2 :
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/case2.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("robots/case2.png could not be read");
                }
                break;
            case 3 :
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/case3.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("robots/case3.png could not be read");
                }
                break;
            default:
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/case3.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("robots/thedragen.png could not be read");
                }
                break;
        */

    }

    /*
    Getters
     */


    /**
     * Returns the image of the robot.
     * @return The image of the robot.

    public BufferedImage getImage() {
        return image;
    }
    */
    /**
     * Returns current hitpoints
     *
     * @return HP
     */
    //
    public int getHP() {
        return hp;
    }

    public void getDir(Direction dirIn) {

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


    public int changeHP(int HP) {
        return hp+=HP;
    }
    public int getID(){
        return this.id;
    }
}