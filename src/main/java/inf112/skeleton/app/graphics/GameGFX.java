package inf112.skeleton.app.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import inf112.skeleton.app.board.IProgramRegister;
import inf112.skeleton.app.card.ICard;
import inf112.skeleton.app.card.ICardMovement;
import inf112.skeleton.app.card.ICardRotation;
import inf112.skeleton.app.game.Game;
import inf112.skeleton.app.game.GameState;
import inf112.skeleton.app.game.PhaseState;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.util.Direction;
import inf112.skeleton.app.util.GameRuleConstants;
import inf112.skeleton.app.util.RobotColors;

import java.util.ArrayList;

import static java.lang.Math.abs;

@SuppressWarnings("Since15")
public class GameGFX extends Stage {
    private final int[] programRegisterPosition = {960, 1080};
    private final ArrayList<MessageGFX> messages = new ArrayList<>();
    private final Timer timer = new Timer();
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private OrthographicCamera camera;
    private ProgramRegisterGFX programRegisterGFX;
    private SpriteBatch batch;
    private SpriteBatch absoluteBatch;
    private Texture cardBack;
    private Texture cardFront;
    private Sprite[] otherPlayerSprites;
    private Sprite[] robotSprites;
    private Texture laserVertical;
    private Texture laserHorizontal;
    private ArrayList<Sprite> spriteLaserVerticalList;
    private ArrayList<Sprite> spriteLaserHorizontalList;
    private int tilePixelWidth;
    private int tilePixelHeight;
    private int[][] robotPositions;
    //Used for testing, should not be pushed
    private boolean showCards = false;
    private BitmapFont font;
    private int cardId = 0;
    private Game game;

    void create(int numPlayersIn, int numAIIn, TiledMap tiledMapIn) {
        spriteLaserVerticalList = new ArrayList<>();
        spriteLaserHorizontalList = new ArrayList<>();
        tiledMap = tiledMapIn;
        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Menu menu = new Menu();
        //opens a Menu and gets the tiledmap from the menu class.
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        Gdx.input.setInputProcessor(menu);

        MapProperties properties = tiledMap.getProperties();
        tilePixelWidth = properties.get("tilewidth", Integer.class);
        tilePixelHeight = properties.get("tileheight", Integer.class);
        createGame(numPlayersIn + numAIIn, numPlayersIn);
        initialiseSprites(numPlayersIn + numAIIn);

        Timer.Task updateMessageDurations = new Timer.Task() {
            @Override
            public void run() {
                decreaseMessageTimer();
            }
        };
        timer.scheduleTask(updateMessageDurations, 0f, 1f, Integer.MAX_VALUE);
        timer.start();
        int x = -850;
        int y = 1210;
        for (int i = 0; i < otherPlayerSprites.length; i++) {
            int[] tempPos = {x, y};
            MessageGFX tempMessage = new MessageGFX("Robot " + (i + 1) + " active cards:", tempPos, false, 2);
            messages.add(tempMessage);
            y -= tilePixelHeight * 2;
        }
    }

    private void initialiseSprites(int numberOfSprites) {
        laserHorizontal = new Texture(Gdx.files.internal("assets/laserHorizontal.png"));
        laserVertical = new Texture(Gdx.files.internal("assets/laserVertical.png"));
        batch = new SpriteBatch();
        absoluteBatch = new SpriteBatch();
        otherPlayerSprites = new Sprite[numberOfSprites];
        robotSprites = new Sprite[game.getAllProgramRegisters().size()];
        RobotColors robotColors = RobotColors.BLACK;
        for (int i = 0; i < robotSprites.length; i++) {
            robotSprites[i] = new Sprite(new Texture((Gdx.files.internal(robotColors.getColor()))));
            robotColors = robotColors.next();
        }
        programRegisterGFX = new ProgramRegisterGFX(programRegisterPosition[0], programRegisterPosition[1]);

        cardBack = new Texture(Gdx.files.internal("assets/card_back.png"));
        cardFront = new Texture(Gdx.files.internal("assets/card_front.png"));
        Sprite[] cards = new Sprite[5];
        for (int i = 0; i < 5; i++) {
            cards[i] = new Sprite(cardBack);
            cards[i].setPosition(programRegisterPosition[0] + 10 + (i * 110), programRegisterPosition[1] - 80);
        }
    }

    private void initialiseRobotLasers() {
        ArrayList<IProgramRegister> robotRegister = game.getAllProgramRegisters();
        spriteLaserVerticalList = new ArrayList<>();
        for (IProgramRegister register : robotRegister) {
            Direction tempDir = register.getRobot().getDir();
            int[] tempPos;
            int j = register.getRobot().getDir().getDirectionValue();
            tempPos = register.getRobot().getPosition().clone();
            for (int k = 0; k < 20; k++) {
                if (register.isDestroyed()) break;
                if (game.checkForWall(tempPos, tempDir)) break;

                tempPos = game.getPositionInDirection(tempPos, tempDir);
                if (j % 2 == 0) {
                    spriteLaserVerticalList.add(new Sprite(laserVertical));
                    spriteLaserVerticalList.get(k).setPosition((tilePixelWidth) * tempPos[0] + 40, (tilePixelHeight) * tempPos[1] + 3);
                    spriteLaserVerticalList.get(k).draw(batch);
                    if (!game.possibleLaser(tempPos, tempDir)) break;
                } else {
                    spriteLaserHorizontalList.add(new Sprite(laserHorizontal));
                    spriteLaserHorizontalList.get(k).setPosition(tilePixelWidth * tempPos[0] + 3, tilePixelHeight * tempPos[1] + 40);
                    spriteLaserHorizontalList.get(k).draw(batch);
                    if (!game.possibleLaser(tempPos, tempDir)) break;
                }
            }
        }
    }

    private void createGame(int numberOfPlayers, int numberOfRealPlayers) {
        game = new Game(tiledMap, numberOfPlayers, numberOfRealPlayers);
        robotPositions = new int[numberOfPlayers][3];
        for (int i = 0; i < numberOfPlayers; i++) {
            robotPositions[i][0] = game.getAllProgramRegisters().get(i).getRobot().getPosition()[0] * tilePixelWidth;
            robotPositions[i][1] = game.getAllProgramRegisters().get(i).getRobot().getPosition()[1] * tilePixelHeight;
            robotPositions[i][2] = 180;
        }

        Timer.Task progressGame = new Timer.Task() {
            @Override
            public void run() {
                progressGame();
            }
        };
        float updateInterval;
        //Makes the game run 9x faster than usual (when using only AI), used only for testing (and fun)
        boolean ANARCHY_MODE = false;
        if (game.checkIfGameHasHumanPlayers()) {
            updateInterval = 0.5f;
        } else if (ANARCHY_MODE) {
            updateInterval = 0.1f;
        } else {
            updateInterval = 0.3f;
        }
        timer.scheduleTask(progressGame, 1f, updateInterval, Integer.MAX_VALUE);
    }

    private void progressGame() {
        game.progressRound(this);
    }

    //Used to render the robot
    private void calculateRobotPosition(int robotId) {
        IRobot robot = game.getAllProgramRegisters().get(robotId).getRobot();

        int xPos = robot.getPosition()[0];
        int yPos = robot.getPosition()[1];
        int desiredAngle = robot.getDir().getDirectionInDegrees();
        if (desiredAngle == 180) {
            desiredAngle = 0;
        } else if (desiredAngle == 0) {
            desiredAngle = 180;
        }

        int currentAngle = robotPositions[robotId][2];
        if (currentAngle < desiredAngle) {
            if (abs(desiredAngle - currentAngle) > 180)
                currentAngle -= 10;
            else
                currentAngle += 10;
        } else if (currentAngle > desiredAngle) {
            if (abs(desiredAngle - currentAngle) > 180)
                currentAngle += 10;
            else
                currentAngle -= 10;
        }

        currentAngle = Math.floorMod(currentAngle, 360);

        robotPositions[robotId][2] = currentAngle;

        if (robotPositions[robotId][0] > xPos * tilePixelWidth + 5)
            robotPositions[robotId][0] -= 5;
        else if (robotPositions[robotId][0] < xPos * tilePixelWidth + 5)
            robotPositions[robotId][0] += 5;
        if (robotPositions[robotId][1] > yPos * tilePixelHeight + 5)
            robotPositions[robotId][1] -= 5;
        else if (robotPositions[robotId][1] < yPos * tilePixelHeight + 5)
            robotPositions[robotId][1] += 5;
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.begin();
        batch.setProjectionMatrix(camera.combined);

        if (game.checkIfGameHasHumanPlayers()) {
            programRegisterGFX.render(batch, game.getCurrentRegister().getDamage(), game.getCurrentRegister().getLives(), game.getCurrentRegister().isPoweredDown(), game.getCurrentRegister().getFlagCounter());
            renderActiveCards(programRegisterPosition[0] + 10, programRegisterPosition[1] - 80, game.getCurrentRegister(), true); //Renders the cards on the program register
        }
        renderRobots();
        if (game.getPhaseState().equals(PhaseState.FIRE_LASERS)) {
            initialiseRobotLasers();
        }
        batch.end();
        if (showCards && game.checkIfGameHasHumanPlayers())
            renderAvailableCards(game.getCurrentRegister().getAvailableCards());
        batch.begin();

        renderText();
        if (game.getGameState() == GameState.EXECUTING_PHASES) {
            changeOtherActiveCardsVisibility(true);
            int y = 1125;
            for (int i = 0; i < otherPlayerSprites.length; i++) { //Renders the cards of all of the robots as they are flipped
                renderActiveCards(-575, y, game.getAllProgramRegisters().get(i), false);
                y -= tilePixelHeight * 2;
            }
        } else
            changeOtherActiveCardsVisibility(false);
        batch.end();
    }

    private void renderActiveCards(int xPos, int yPos, IProgramRegister register, boolean ignoreFlipped) {
        ArrayList<ICard> activeCards = register.getActiveCards();
        Sprite[] activeCardArray = new Sprite[activeCards.size()];

        for (int i = 0; i < activeCardArray.length; i++) {
            if (activeCards.get(i) == null)
                break;

            boolean drawText = false;
            if (register.getIsCardFlipped()[i] || ignoreFlipped) {
                activeCardArray[i] = new Sprite(cardFront);
                drawText = true;
            } else
                activeCardArray[i] = new Sprite(cardBack);

            activeCardArray[i].setPosition(i * 110 + xPos, yPos);
            activeCardArray[i].draw(batch);

            if (drawText) {
                font.draw(batch, Integer.toString(activeCards.get(i).getPriority()), i * 110 + 56 + xPos, yPos + 136);
                int type = activeCards.get(i).getType();
                font.draw(batch, createCardTypeString(type, activeCards, i), i * 110 + 25 + xPos, yPos + 100);
            }
        }
    }

    private void changeOtherActiveCardsVisibility(boolean shouldBeVisible) {
        for (MessageGFX message : messages) {
            if (message.getMessage().contains("Robot")) {
                message.setVisible(shouldBeVisible);
            }
        }
    }

    private void renderRobots() {
        for (int i = 0; i < robotSprites.length; i++) {
            calculateRobotPosition(i);
            //Subtracts 1 in the otherPlayerSprites array since it's 1 shorter in length
            robotSprites[i].setPosition(robotPositions[i][0], robotPositions[i][1]);
            robotSprites[i].setRotation(robotPositions[i][2]);
            if (!game.getAllProgramRegisters().get(i).isDestroyed()) {
                robotSprites[i].draw(batch);
            }
        }
    }

    private void renderAvailableCards(ArrayList<ICard> availableCards) {
        Sprite[] cardSpriteTest = new Sprite[GameRuleConstants.MAX_CARDS_IN_REGISTER.getValue()];

        absoluteBatch.begin();
        for (int i = 0; i < cardSpriteTest.length; i++) {
            if (i < availableCards.size()) {
                cardSpriteTest[i] = new Sprite(cardFront);

                int y = 10;
                if (i == cardId)
                    y += 20;

                cardSpriteTest[i].setPosition(i * 105f + 15f, y);
                cardSpriteTest[i].setSize(90f, 140f);
                cardSpriteTest[i].draw(absoluteBatch);

                font.draw(absoluteBatch, Integer.toString(availableCards.get(i).getPriority()), i * 105 + 66, y + 128);
                int type = availableCards.get(i).getType();

                font.draw(absoluteBatch, createCardTypeString(type, availableCards, i), i * 105 + 35, y + 100);
            } else {
                cardSpriteTest[i] = new Sprite(cardBack);
                int y = 10;
                if (i == cardId)
                    y += 20;

                cardSpriteTest[i].setPosition(i * 105 + 15, y);
                cardSpriteTest[i].setSize(90f, 140f);
                cardSpriteTest[i].draw(absoluteBatch);
            }
        }
        absoluteBatch.end();
    }

    private String createCardTypeString(int type, ArrayList<ICard> cards, int i) {
        String strType = "";
        String strValue = "";
        String strDir = "";
        if (type == 1) {
            ICardMovement tempCard = (ICardMovement) cards.get(i);
            strType = "Move";
            strValue = Integer.toString(tempCard.getMoveValue());
        } else if (type == 2) {
            ICardRotation tempCard = (ICardRotation) cards.get(i);
            strType = "Rotate";
            strValue = Integer.toString(tempCard.getRotationValue());
            if (tempCard.getRotationDirection())
                strDir = "RIGHT";
            else
                strDir = "LEFT";
        }
        return strType + " " + strValue + "\n" + strDir;
    }

    private void choseCard() {
        game.getCurrentRegister().makeCardActive(cardId);
    }

    private void decreaseMessageTimer() {
        for (int i = 0; i < messages.size(); i++) {
            MessageGFX message = messages.get(i);
            if (message.hasDuration()) {
                if (message.decreaseDuration()) {
                    messages.remove(message);
                    i--;
                }
            }
        }
    }

    public void printTextToDefaultPosition(String input, float scale, float duration) {
        int[] defaultPos = {1000, 800};
        print(input, defaultPos, scale, duration);
    }

    private void print(String input, int[] position, float scale, float duration) {
        MessageGFX tempMessage = new MessageGFX(input, position, true, scale, duration);
        messages.add(tempMessage);
    }

    private void renderText() {
        float oldScaleX = font.getData().scaleX;
        float oldScaleY = font.getData().scaleY;
        for (MessageGFX message : messages) {
            if (message.isVisible()) {
                font.getData().setScale(message.getScale(), message.getScale());
                font.draw(batch, message.getMessage(), message.getPosition()[0], message.getPosition()[1]);
            }
        }
        font.getData().setScale(oldScaleX, oldScaleY);
    }

    public void flipShowCard() {
        showCards = !showCards;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (game.getGameState() == GameState.ANNOUNCING_POWER_DOWN) {
            if (keycode == Input.Keys.Y) {
                game.powerDownRobot(game.getCurrentRegister(), true);
                game.progressGameState();
            }
            if (keycode == Input.Keys.N) {
                game.powerDownRobot(game.getCurrentRegister(), false);
                game.progressGameState();
            }

        }

        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.A) {
            if (showCards) {
                if (cardId == 0)
                    cardId = game.getCurrentRegister().getAvailableCards().size() - 1;
                else
                    cardId--;
            }
        }
        if (keycode == Input.Keys.RIGHT || keycode == Input.Keys.D) {
            if (showCards) {
                if (cardId == game.getCurrentRegister().getAvailableCards().size() - 1)
                    cardId = 0;
                else
                    cardId++;
            }
        }
        if (keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if (keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        if (keycode == Input.Keys.NUM_3)
            tiledMap.getLayers().get(2).setVisible(!tiledMap.getLayers().get(2).isVisible());
        if (keycode == Input.Keys.NUM_4)
            tiledMap.getLayers().get(3).setVisible(!tiledMap.getLayers().get(3).isVisible());
        if (keycode == Input.Keys.NUM_5)
            tiledMap.getLayers().get(4).setVisible(!tiledMap.getLayers().get(4).isVisible());
        if (keycode == Input.Keys.ENTER) {
            if (showCards) {
                choseCard();
                if (cardId == game.getCurrentRegister().getAvailableCards().size())
                    cardId--;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        float x = Gdx.input.getDeltaX() * camera.zoom;
        float y = Gdx.input.getDeltaY() * camera.zoom;

        camera.translate(-x, y);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        //noinspection UnnecessaryLocalVariable
        float zoomAmount = amount;
        camera.zoom += zoomAmount / 10;
        return true;
    }

    public boolean gameOver() {
        return game.gameOver();
    }

    public IRobot getWinner() {
        return game.winCheck();
    }

}
