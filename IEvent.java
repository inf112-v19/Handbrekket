package inf112.skeleton.app;

/**
 * All actions in game
 */
public interface IEvent {

    /**
     * moves a robot
     */
    void moveRobot ();
    /**
     * fire a laser from board
     */
    void foreLaserRobots();
    /**
     * fire laser from Board
     */
    void fireLaserBoard();
    /**
     * repair a robot
     */
    void repair();
    /**
     * conveyor belts
     */
    void conveyorBelt ();
    /**
     * moves a robot
     */
    void dealProgramCards ();
    /**
     * moves a robot
     */
    boolean powerDownCheck ();
    /**
     * moves a robot
     */
    void revealProgramCards ();
    /**
     * moves a robot
     */
    // void activatePushers();
    /**
     * moves a robot
     */
    void activateGears ();
    /**
     * moves a robot
     */
    void rotateRobot ();
    /**
     * moves a robot
     */
    void flagCheck(); /* Check if we need one checkFlags and one catchFlags or only one method for flags*/
    /**
     * moves a robot
     */
    void removeProgramCards ();

    void destructionCheck();

    void winCheck ();
}
