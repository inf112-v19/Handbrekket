package inf112.skeleton.app.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.skeleton.app.robot.IRobot;

class EndGFX extends Stage {
    private Sprite menu;
    private Batch batch;
    private BitmapFont font;
    private String endMessage;

    void create(boolean win, IRobot robotIn) {
        Texture menuBack = new Texture(Gdx.files.internal("assets/menuBack.png"));
        menu = new Sprite(menuBack);
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        menu.setPosition(50, 50);
        font = new BitmapFont();
        font.getData().setScale(3, 3);
        font.setColor(Color.BLACK);
        if (win && robotIn.getID() != 10) {
            endMessage = ("The winner is:  Robot ".concat(Integer.toString(robotIn.getID())));
        } else {
            endMessage = "Game Over";
        }
    }

    void render() {
        batch.begin();
        menu.draw(batch);

        font.draw(batch, endMessage, 250, 300);
        batch.end();
    }
}
