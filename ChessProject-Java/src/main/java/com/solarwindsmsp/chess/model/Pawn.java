package com.solarwindsmsp.chess.model;

import java.text.MessageFormat;
import com.solarwindsmsp.chess.ChessBoard;

public class Pawn extends ChessPiece {

    private static final int MAX_NUMBER_OF_PIECES = ChessBoard.MAX_BOARD_WIDTH;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        this.movementStrategy = new PawnMovementStrategy();
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE) {
            movementStrategy.moveToPosition(this, newX, newY);
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        String eol = System.lineSeparator();
        return MessageFormat.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }

    @Override
    public int getMaxNumberOfPiecesAllowed() {
        return MAX_NUMBER_OF_PIECES;
    }
}
