package inf112.skeleton.app.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ProgramRegisterGFX {
    private Texture texture;
    private Texture textureP;
    private Texture damage;
    private Texture damageRed;
    private Texture damageBack;
    private Sprite[] damageArr;
    private Sprite spriteDamageRed;
    private Sprite[] damageArrback;
    private Sprite spriteP;


    public ProgramRegisterGFX(){
        textureP = new Texture(Gdx.files.internal("assets/programRegister.png"));
        spriteP = new Sprite(textureP);
        spriteP.setPosition(960, 760);

        damage = new Texture(Gdx.files.internal("assets/damage.png"));
        damageArr = new Sprite[9];
        damageRed = new Texture(Gdx.files.internal("assets/damage_red.png"));
        spriteDamageRed = new Sprite(damageRed);
        spriteDamageRed.setPosition(1000, 857);
        damageBack = new Texture(Gdx.files.internal("assets/damage_background.png"));
        damageArrback = new Sprite[9];
        for(int i = 0; i < damageArrback.length; i++){
            damageArrback[i] = new Sprite(damageBack);
            damageArrback[i].setPosition((1047+(i*50)),857);
        }
        for(int i = 0; i < damageArr.length; i++){
            damageArr[i] = new Sprite(damage);
            damageArr[i].setPosition((1050+(i*50)),860);
        }

    }
    public void render(SpriteBatch batch, int hp, int lives){
        spriteP.draw(batch);
        spriteDamageRed.draw(batch);
        for (int i = 0; i < damageArrback.length; i++){
            damageArrback[i].draw(batch);
        }
        for (int i = hp; i < damageArr.length; i++){
            damageArr[i].draw(batch);
        }
    }
}
