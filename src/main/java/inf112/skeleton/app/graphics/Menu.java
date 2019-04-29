package inf112.skeleton.app.graphics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Menu extends ApplicationAdapter implements InputProcessor {
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

    public void create(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);

        tiledMap = new TmxMapLoader().load("assets/map1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        batch = new SpriteBatch();
        menuBackground = new Texture(Gdx.files.internal("assets/menuBack.png"));
        spriteMenuBackground = new Sprite(menuBackground);
        spriteMenuBackground.setPosition(65,100);
    }
    public void render(){
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        spriteMenuBackground.draw(batch);
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
    public boolean keyUp(int i) {
        return false;
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
