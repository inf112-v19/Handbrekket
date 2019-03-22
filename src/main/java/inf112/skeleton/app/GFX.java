package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.game.IGame;

public class GFX extends ApplicationAdapter implements InputProcessor{
    private Texture img;
    private TiledMap tiledMap;
    private  TiledMapTileLayer layer;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;
    private IGame game;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;


    @Override
    public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        game = new Game(1);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        tiledMap = new TmxMapLoader().load("assets/testFredag.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        Gdx.input.setInputProcessor(this);

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("assets/bot-g.gif"));
        sprite = new Sprite(texture);
        sprite.setPosition(20, 20);
        tiledMap.getTileSets();
        TiledMapTileSets mapSet = tiledMap.getTileSets();
        layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        layer.getCell(sprite.getRegionX(),sprite.getRegionY());
        MapObjects objects = layer.getObjects();

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A)
            sprite.setPosition(sprite.getX() - 80, sprite.getY());
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D)
            sprite.setPosition(sprite.getX() + 80, sprite.getY());
        if(keycode == Input.Keys.UP || keycode == Input.Keys.W)
            sprite.setPosition(sprite.getX(), sprite.getY() + 80);
        if(keycode == Input.Keys.DOWN || keycode == Input.Keys.S)
            sprite.setPosition(sprite.getX(), sprite.getY() - 80);
        if(keycode == Input.Keys.Q)
            sprite.rotate90(true);
        if(keycode == Input.Keys.E)
            sprite.rotate90(false);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char character) {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
