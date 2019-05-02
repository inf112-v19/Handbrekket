package inf112.skeleton.app;

import inf112.skeleton.app.board.Laser;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LaserTest {
    private Laser testLaser;
    private int x =  0;
    private int y =  1;
    private boolean isVertical = true;
    private int damage = 2;

    @Before
    public void setup() {
        testLaser = new Laser(damage,isVertical,x,y );
    }
    @Test
    public void xTest() { assertEquals(x,testLaser.getPosition()[0]);
    }

    @Test
    public void yTest(){ assertEquals(y,testLaser.getPosition()[1]);
    }

    @Test
    public void DamageTest(){assertEquals(damage,testLaser.getDamage());
    }

    @Test
    public void isVerticalTest (){assert(testLaser.isVertical());}
}
