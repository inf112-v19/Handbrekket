package inf112.skeleton.app;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.lwjgl.Sys;


import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Board";
        cfg.width = 576;
        cfg.height = 576;

        new LwjglApplication(new GFX(), cfg);
    }

}