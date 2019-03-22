package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.game.IGame;
import inf112.skeleton.app.robot.Robot;

import java.util.ArrayList;

public class GFX extends ApplicationAdapter implements InputProcessor{
    Texture img;
    TiledMap tiledMap;
    TiledMapTileLayer layer;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    ShapeRenderer shapeRenderer;

    SpriteBatch batch;
    Texture texture;
    Sprite sprite;

    //Used for testing, should not be pushed
    private boolean showCards = false;
    private ArrayList<ICard> testCards;
    //Todo: bad name, fix
    private int cardId = 0;

    @Override
    public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

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

        //Also for testing
        Game game = new Game(new Robot(1,2,3));
        testCards = game.get9Cards();
        shapeRenderer = new ShapeRenderer();
        //printCards();
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
        if(showCards)
            renderCards(testCards);
    }

    private void renderCards(ArrayList<ICard> cards) {
        for(int i = 0; i < cards.size(); i++) {
            int y = 10;
            if(i == cardId)
                y += 20;

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.rect(i*105+15, y, 90, 140);
            shapeRenderer.end();
        }
    }

    //Todo: implement this, somehow
    private void choseCard(IGame game) {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A) {
            if(!showCards)
                sprite.setPosition(sprite.getX() - 80, sprite.getY());
            else {
                if(cardId == 0)
                    cardId = testCards.size() - 1;
                else
                    cardId--;
            }
        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D) {
            if(!showCards)
                sprite.setPosition(sprite.getX() + 80, sprite.getY());
            else {
                if(cardId == testCards.size() - 1)
                    cardId = 0;
                else
                    cardId++;
            }
        }
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
        if(keycode == Input.Keys.C)
            showCards = !showCards;
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
