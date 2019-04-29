package inf112.skeleton.app.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Menu {
    private TiledMap tiledMap;
    private Texture menuBackground;
    private Sprite spriteMenuBackground;
    private boolean showingMenu;

    public Menu(){
        showingMenu = true;
        tiledMap = new TmxMapLoader().load("assets/map1.tmx");
        menuBackground = new Texture(Gdx.files.internal("assets/menuBack.png"));
        spriteMenuBackground = new Sprite(menuBackground);
        spriteMenuBackground.setPosition(65,100);
    }
    public void render(Batch batch){
        if(showMenu()) {
            spriteMenuBackground.draw(batch);
        }
        showingMenu = false;
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
    private boolean showMenu(){
        return showingMenu;
    }

}
