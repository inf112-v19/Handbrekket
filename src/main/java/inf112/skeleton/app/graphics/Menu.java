package inf112.skeleton.app.graphics;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import inf112.skeleton.app.GFX;
import org.lwjgl.Sys;

public class Menu extends ApplicationAdapter implements InputProcessor {
    private Sprite[] increase;
    private Sprite[] decrease;
    private Sprite start;
    private Texture textureIncrease;
    private Texture textureDecrease;
    private Texture textureStart;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private Texture menuBackground;
    private Sprite spriteMenuBackground;
    private Stage stage;
    private TextButton button;
    private TextButton.TextButtonStyle textButtonStyle;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private SpriteBatch batch;
    private int numberOfRealPlayers;
    private int numberOfAI;
    private int mapNumber;
    private boolean menuActive;
    private int currentPosition;

    public void create(){
        currentPosition = 0;
        menuActive = true;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

        tiledMap = new TmxMapLoader().load("assets/map1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        batch = new SpriteBatch();
        initialiseSprites();
        Gdx.input.setInputProcessor(this);
    }
    private void initialiseSprites(){
        menuActive = true;
        menuBackground = new Texture(Gdx.files.internal("assets/menuBack.png"));
        spriteMenuBackground = new Sprite(menuBackground);
        spriteMenuBackground.setPosition(65,100);
        increase = new Sprite[3];
        decrease = new Sprite[3];
        textureIncrease = new Texture(Gdx.files.internal("assets/increase.png"));
        textureDecrease = new Texture(Gdx.files.internal("assets/decrease.png"));
        resetButtons();
        renderButtons();
    }
    private void resetButtons(){
        for(int i = 0; i < 3; i++){
            increase[i] = new Sprite(textureIncrease);
            decrease[i] = new Sprite(textureDecrease);
            increase[i].setPosition(700,700-i*170);
            decrease[i].setPosition(700,620-i*170);
        }
        textureStart = new Texture(Gdx.files.internal("assets/start.png"));
        start = new Sprite(textureStart);
        start.setPosition(700,170);
    }
    private void renderButtons(){
        switch (currentPosition) {
            case (0):
                increase[0].setPosition(increase[0].getX()+20, increase[0].getY());
                break;
            case (1):
                decrease[0].setPosition(decrease[0].getX()+20, decrease[0].getY());
                break;
            case (2):
                increase[1].setPosition(increase[1].getX()+20, increase[1].getY());
                break;
            case (3):
                decrease[1].setPosition(decrease[1].getX()+20, decrease[1].getY());
                break;
            case (4):
                increase[2].setPosition(increase[2].getX()+20, increase[2].getY());
                break;
            case (5):
                decrease[2].setPosition(decrease[2].getX()+20, decrease[2].getY());
                break;
            case (6):
                start.setPosition(start.getX()+20, start.getY());
                break;
        }
    }
    public void render(){
        camera.update();
        tiledMapRenderer.setView(camera);
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        spriteMenuBackground.draw(batch);
        for(int i = 0; i < 3; i++){
            decrease[i].draw(batch);
            increase[i].draw(batch);
        }
        start.draw(batch);
        batch.end();
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

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W) {
            if(menuActive) {
                if (currentPosition > 0) {
                    currentPosition--;
                }
                else currentPosition = 5;
            }
            resetButtons();
            renderButtons();
        }
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S) {
            if(menuActive) {
                if (currentPosition < 6) {
                    currentPosition++;
                }
                else
                    currentPosition = 0;
            }
            resetButtons();
            renderButtons();
        }
        if(keycode == Input.Keys.ENTER) {
            if (menuActive){
                switch (currentPosition) {
                    case (0):
                        numberOfRealPlayers++;
                        break;
                    case (1):
                        numberOfRealPlayers--;
                        break;
                    case (2):
                        numberOfAI++;
                        break;
                    case (3):
                        numberOfAI--;
                        break;
                    case (4):
                        mapNumber++;
                        break;
                    case (5):
                        mapNumber--;
                        break;
                    case (6):
                        initialiseGFX(); //start
                        break;
                }
                System.out.println("NumPlay: " + numberOfRealPlayers);
                System.out.println("NumAI: " + numberOfAI);
                System.out.println("MapNumber: " + mapNumber);
                System.out.println();
            }
        }
        return false;
    }

    private void initialiseGFX() {
        menuActive = false;
        new GFX(numberOfRealPlayers, numberOfAI, tiledMap);
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
