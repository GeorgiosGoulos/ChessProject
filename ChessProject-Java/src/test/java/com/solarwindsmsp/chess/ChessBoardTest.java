package com.solarwindsmsp.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.solarwindsmsp.chess.chesspiece.Pawn;
import com.solarwindsmsp.chess.chesspiece.PieceColor;
import com.solarwindsmsp.chess.chesspiece.Position;

public class ChessBoardTest {

    private ChessBoard testSubject;

    @Before
    public void setUp() throws Exception {
        testSubject = new ChessBoard();
    }

    @Test
    public void testHas_MaxBoardWidth_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testHas_MaxBoardHeight_of_7() {
        assertEquals(7, ChessBoard.MAX_BOARD_HEIGHT);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_0_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(0,0));
        assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_True_X_equals_5_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(5, 5));
        Assert.assertTrue(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_5() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(11, 5));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_0_Y_equals_9() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(0, 9));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_X_equals_11_Y_equals_0() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(11, 0));
        assertFalse(isValidPosition);
    }

    @Test
    public void testIsLegalBoardPosition_False_For_Negative_Y_Values() {
        boolean isValidPosition = testSubject.isLegalBoardPosition(new Position(5, -1));
        Assert.assertFalse(isValidPosition);
    }

    @Test
    public void testAvoids_Duplicate_Positioning() {
        Pawn firstPawn = new Pawn(PieceColor.BLACK);
        Pawn secondPawn = new Pawn(PieceColor.BLACK);
        testSubject.add(firstPawn, new Position(6, 3));
        testSubject.add(secondPawn, new Position(6, 3));
        assertEquals(6, testSubject.getPosition(firstPawn).getX());
        assertEquals(3, testSubject.getPosition(firstPawn).getY());
        assertEquals(ChessBoard.INVALID_WIDTH_POSITION, testSubject.getPosition(secondPawn).getX());
        assertEquals(ChessBoard.INVALID_HEIGHT_POSITION, testSubject.getPosition(secondPawn).getY());
    }

    @Test
    public void testLimits_The_Number_Of_Pawns()
    {
        for (int i = 0; i < 10; i++)
        {
            Pawn pawn = new Pawn(PieceColor.BLACK);
            int row = i / ChessBoard.MAX_BOARD_WIDTH;
            int xCoordinate = 6 + row;
            int yCoordinate = i % ChessBoard.MAX_BOARD_WIDTH;
            testSubject.add(pawn, new Position(xCoordinate, yCoordinate));
            if (row < 1)
            {
                assertEquals(6 + row, testSubject.getPosition(pawn).getX());
                assertEquals(i % ChessBoard.MAX_BOARD_WIDTH, testSubject.getPosition(pawn).getY());
            }
            else
            {
                assertEquals(-1, testSubject.getPosition(pawn).getX());
                Assert.assertEquals(-1, testSubject.getPosition(pawn).getY());
            }
        }
    }
}