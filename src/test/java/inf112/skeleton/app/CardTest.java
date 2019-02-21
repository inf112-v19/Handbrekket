package inf112.skeleton.app;

import inf112.skeleton.app.card.MovementCard;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    //List of the number of each card type
    private static final int MOVE_1_CARDNUM = 18;
    private final int MOVE_1_INTERVAL       = 10;
    private final int MOVE_1_INTERVALSTART  = 490;

    private static MovementCard[] cardArray;

    @BeforeClass
    public static void createArray(){
        cardArray = new MovementCard[MOVE_1_CARDNUM];

        for(int i = 0; i < cardArray.length; i++){
            cardArray[i] = new MovementCard(490 + i * 10, 1);
        }
    }

    @Test
    public void priorityTests(){
        for(int i = 0; i < cardArray.length; i++){
            assertEquals(MOVE_1_INTERVALSTART + i * MOVE_1_INTERVAL, cardArray[i].getPriority());
        }
    }

    @Test
    public void moveValueTest(){
        for(MovementCard card : cardArray){
            assertEquals(1, card.getMoveValue());
        }
    }

    @Test
    public void typeTest(){
        for(MovementCard card : cardArray){
            assertEquals(1, card.getType());
        }
    }
}
