package inf112.skeleton.app.graphics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import inf112.skeleton.app.robot.IRobot;
import inf112.skeleton.app.robot.Robot;

@SuppressWarnings("Since15")
public class GFX extends ApplicationAdapter {
    private boolean createGFX;
    private Menu menu;
    private GameGFX gameGFX;
    private EndGFX end;
    private boolean run;
    private boolean renderGFX;

    public void create() {
        run = true;
        createGFX = true;
        menu = new Menu();
        gameGFX = new GameGFX();
        end = new EndGFX();
        Gdx.input.setInputProcessor(menu);
        renderGFX = false;

    }

    @Override
    public void render() {
        if(menu.isMenuActive()) {
            menu.render();
        }
        else if(createGFX){
            menu.dispose();
            gameGFX.create(menu.getNumberOfRealPlayers(), menu.getNumbersOfAI(), menu.getTiledMap());
            createGFX = false;
            renderGFX = true;
            }
        else if(run)
            if(gameGFX.gameOver()){
                end.create(gameGFX.gameOver(), gameGFX.getWinner());
                createGFX = false;
                gameGFX.dispose();
                end.render();
                run = false;
                renderGFX = false;
            }
        else if(!run && !renderGFX){
                end.render();
            }
        if(renderGFX) {
            gameGFX.render();
            Gdx.input.setInputProcessor(gameGFX);
        }
    }
}
/**
 * VIKTIG!
 * Menyen sender per nå kun antall ekte spillere videre.
 *
 */

