package com.solarwindsmsp.chess;

import org.junit.Before;
import com.solarwindsmsp.chess.chesspiece.Pawn;
import com.solarwindsmsp.chess.chesspiece.PieceColor;

public class PawnTest {

    private ChessBoard chessBoard;
    private Pawn testSubject;

    @Before
    public void setUp() {
        this.chessBoard = new ChessBoard();
        this.testSubject = new Pawn(PieceColor.BLACK);
    }
    
}