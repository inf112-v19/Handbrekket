package inf112.skeleton.app;

import static org.junit.Assert.assertEquals;

import inf112.skeleton.app.board.Board;
import inf112.skeleton.app.board.IBoard;
import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testHeightAndWidth(){
		for(int i = 1; i <200; i++) {
			for( int j = 1; j <200; j++) {
				IBoard board = new Board(i,j);
				widthTest(i, board);
				heightTest(j, board);
			}
		}
	}
	public void widthTest (int i, IBoard board){
		assertEquals(i, board.getWidth());
	}
	public void heightTest (int j , IBoard board){
		assertEquals(j, board.getHeight());
		
	}
	
}

	