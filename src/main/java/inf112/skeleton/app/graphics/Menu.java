package inf112.skeleton.app.graphics;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class Menu {
    private TiledMap tiledMap;
    private BitmapFont font;


    public Menu(){
        font = new BitmapFont();

        tiledMap = new TmxMapLoader().load("assets/map1.tmx");

    }
    public int getNumberOfRealPlayers(){
        return 1;
    }
    public int getNumbersOfAI(){
        return 0;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

}
