package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.lwjgl.Sys;


import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "hello-world";
        cfg.width = 480;
        cfg.height = 320;



        new LwjglApplication(new HelloWorld(), cfg);

    }

    public void run () {
        Board board = new Board(50,50);
        board.printBoard();

    }
}