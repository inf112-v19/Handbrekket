package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.board.IProgramRegister;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.ICardRotation;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.game.GameRuleConstants;
import inf112.skeleton.app.robot.IRobot;

import java.util.ArrayList;

public class GFX extends ApplicationAdapter implements InputProcessor{
    private TiledMap tiledMap;
    private TiledMapTileLayer layer;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;

    private ShapeRenderer shapeRenderer;

    private SpriteBatch batch;
    private Texture texture;
    private Texture textureP;
    private Texture damage;
    private Texture damageRed;
    private Texture damageBack;
    private Texture cardBack;
    private Texture cardFront;

    private Sprite sprite;
    private Sprite spriteP;
    private Sprite spriteCardBack;
    private Sprite spriteCardFront;
    private Sprite[] damageArr;
    private Sprite[] getDamageArrBack;
    private Sprite spriteDamageRed;
    private Sprite[] damageArrback;
    private Sprite[] cards;

    private int tilePixelWidth;
    private int tilePixelHeight;

    //Used for testing, should not be pushed
    private boolean showCards = false;
    private BitmapFont font;
    //Todo: bad name, fix
    private int cardId = 0;

    //TODO: remove at some point
    private int phaseNumber = 0;

    private Game game;

    @Override
    public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        font = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        tiledMap = new TmxMapLoader().load("assets/tilemap.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        MapProperties properties = tiledMap.getProperties();
        tilePixelWidth = properties.get("tilewidth", Integer.class);
        tilePixelHeight = properties.get("tileheight", Integer.class);

        Gdx.input.setInputProcessor(this);

        //TODO: the amount of players should not be hard-coded
        game = new Game(tiledMap, 1);
        game.dealCards();

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("assets/bot-g.gif"));
        sprite = new Sprite(texture);
        sprite.setSize(tilePixelWidth - 10, tilePixelHeight - 10);
        tiledMap.getTileSets();
        TiledMapTileSets mapSet = tiledMap.getTileSets();
        layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        layer.getCell(sprite.getRegionX(),sprite.getRegionY());
        MapObjects objects = layer.getObjects();

        textureP = new Texture(Gdx.files.internal("assets/programRegister.png"));
        spriteP = new Sprite(textureP);
        spriteP.setPosition(960, 760);

        cardBack = new Texture(Gdx.files.internal("assets/card_back.png"));
        cardFront = new Texture(Gdx.files.internal("assets/card_front.png"));
        damage = new Texture(Gdx.files.internal("assets/damage.png"));
        damageArr = new Sprite[9];
        damageRed = new Texture(Gdx.files.internal("assets/damage_red.png"));
        spriteDamageRed = new Sprite(damageRed);
        spriteDamageRed.setPosition(1000, 857);
        damageBack = new Texture(Gdx.files.internal("assets/damage_background.png"));
        damageArrback = new Sprite[9];
        spriteCardBack = new Sprite(cardBack);
        spriteCardFront = new Sprite(cardFront);
        cards = new Sprite[5];
        for(int i = 0; i < 5; i++){
            cards[i] = new Sprite(cardBack);
            cards[i].setPosition(970+(i*110), 680);
        }
        for(int i = 0; i < damageArrback.length; i++){
            damageArrback[i] = new Sprite(damageBack);
            damageArrback[i].setPosition((1047+(i*50)),857);
        }
        for(int i = 3; i < damageArr.length; i++){
            damageArr[i] = new Sprite(damage);
            damageArr[i].setPosition((1050+(i*50)),860);
        }
        spriteCardBack = new Sprite(cardBack);
        spriteCardFront = new Sprite(cardFront);
    }

    //Used to render the robot
    private void calculateRobotPosition() {
        IRobot robot = game.getCurrentRegister().getRobot();

        int xPos = robot.getPosition()[0];
        int yPos = robot.getPosition()[1];
        //TODO: find out why the setRotation offsets the position by -25 pixels
        sprite.setPosition(xPos * tilePixelHeight + 5, yPos * tilePixelWidth + 5);
        sprite.setRotation(robot.getDir().getDirectionInDegrees());
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

        calculateRobotPosition();
        sprite.draw(batch);
        spriteP.draw(batch);
        spriteDamageRed.draw(batch);
        for (int i = 0; i < 5; i++){
            cards[i].draw(batch);
        }
        for (int i = 0; i < damageArrback.length; i++){
            damageArrback[i].draw(batch);
        }
        for (int i = 3; i < damageArr.length; i++){
            damageArr[i].draw(batch);
        }
        batch.end();
        if(showCards)
            renderAvailableCards(game.getCurrentRegister().getAvailableCards());
        renderActiveCards(game.getCurrentRegister().getActiveCards());
    }

    //TODO: reduce redundant code repetition
    private void renderAvailableCards(ArrayList<ICard> availableCards) {
        Sprite[] cardSpriteTest = new Sprite[GameRuleConstants.MAX_CARDS_IN_REGISTER.getValue()];

        batch.begin();
        for(int i = 0; i < cardSpriteTest.length; i++) {
            if(i < availableCards.size()) {
                cardSpriteTest[i] = new Sprite(cardFront);

                int y = 10;
                if (i == cardId)
                    y += 20;

                cardSpriteTest[i].setPosition(i * 105f + 15f, y);
                cardSpriteTest[i].setSize(90f, 140f);
                cardSpriteTest[i].draw(batch);

                //TODO: most of this should be replaced with images instead, priority should still be drawn manually
                font.draw(batch, Integer.toString(availableCards.get(i).getPriority()), i * 105 + 66, y + 128);
                int type = availableCards.get(i).getType();
                String strType = "";
                String strValue = "";
                String strDir = "";
                if (type == 1) {
                    ICardMovement tempCard = (ICardMovement) availableCards.get(i);
                    strType = "Move";
                    strValue = Integer.toString(tempCard.getMoveValue());
                } else if (type == 2) {
                    ICardRotation tempCard = (ICardRotation) availableCards.get(i);
                    strType = "Rotate";
                    strValue = Integer.toString(tempCard.getRotationValue());
                    if (tempCard.getRotationDirection())
                        strDir = "RIGHT";
                    else
                        strDir = "LEFT";
                }
                String str = strType + " " + strValue + "\n" + strDir;
                font.draw(batch, str, i * 105 + 35, y + 100);
            } else {
                cardSpriteTest[i] = new Sprite(cardBack);
                int y = 10;
                if (i == cardId)
                    y += 20;

                cardSpriteTest[i].setPosition(i * 105 + 15, y);
                cardSpriteTest[i].setSize(90f,140f);
                cardSpriteTest[i].draw(batch);
            }
        }
        batch.end();
    }

    private void renderActiveCards(ArrayList<ICard> activeCards) {
        Sprite[] activeCardArray = new Sprite[activeCards.size()];

        batch.begin();
        for(int i = 0; i < activeCardArray.length; i++) {
            if(activeCards.get(i) == null)
                break;

            activeCardArray[i] = new Sprite(cardFront);

            int y = 680;
            int x = 970;
            activeCardArray[i].setPosition(i * 110 + x, y);
            //activeCardArray[i].setSize();
            activeCardArray[i].draw(batch);


            font.draw(batch, Integer.toString(activeCards.get(i).getPriority()), i * 110 + 56 + x, y + 136);
            //TODO: duplicate code, but should be replaced anyway
            int type = activeCards.get(i).getType();
            String strType = "";
            String strValue = "";
            String strDir = "";
            if(type == 1) {
                ICardMovement tempCard = (ICardMovement) activeCards.get(i);
                strType = "Move";
                strValue = Integer.toString(tempCard.getMoveValue());
            } else if(type == 2) {
                ICardRotation tempCard = (ICardRotation) activeCards.get(i);
                strType = "Rotate";
                strValue = Integer.toString(tempCard.getRotationValue());
                if(tempCard.getRotationDirection())
                    strDir = "RIGHT";
                else
                    strDir = "LEFT";
            }
            String str = strType+ " " + strValue + "\n" + strDir;
            font.draw(batch, str,i * 110 + 25 + x, y + 100);
        }
        batch.end();
    }

    private void choseCard() {
        game.getCurrentRegister().makeCardActive(cardId);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        //TODO: make the max not be hard-coded here
        if(keycode == Input.Keys.LEFT || keycode == Input.Keys.A) {
            if(showCards) {
                if(cardId == 0)
                    cardId = 9 - 1;
                else
                    cardId--;
            }
        }
        if(keycode == Input.Keys.RIGHT || keycode == Input.Keys.D) {
            if(showCards) {
                if(cardId == 9 - 1)
                    cardId = 0;
                else
                    cardId++;
            }
        }
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        if(keycode == Input.Keys.NUM_3)
            tiledMap.getLayers().get(2).setVisible(!tiledMap.getLayers().get(2).isVisible());
        if(keycode == Input.Keys.NUM_4)
            tiledMap.getLayers().get(3).setVisible(!tiledMap.getLayers().get(3).isVisible());
        if(keycode == Input.Keys.NUM_5)
            tiledMap.getLayers().get(4).setVisible(!tiledMap.getLayers().get(4).isVisible());
        if(keycode == Input.Keys.C)
            showCards = !showCards;
        if(keycode == Input.Keys.ENTER) {
            if(showCards)
                choseCard();
        }
        if(keycode == Input.Keys.SPACE)
            game.doPhase(phaseNumber++);

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
