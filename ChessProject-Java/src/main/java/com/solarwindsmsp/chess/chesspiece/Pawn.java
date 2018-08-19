package com.solarwindsmsp.chess.chesspiece;

import com.solarwindsmsp.chess.ChessBoard;

public class Pawn extends ChessPiece {

    private static final int MAX_NUMBER_OF_PIECES = ChessBoard.MAX_BOARD_WIDTH;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public int getMaxNumberOfPiecesAllowed() {
        return MAX_NUMBER_OF_PIECES;
    }

    @Override
    public boolean canMoveToPosition(MovementDetails details) {
        
        if (details == null) {
            throw new IllegalArgumentException("details is null");
        }
        
        // TODO: To be used when support for capture is added
        MovementType movementType = details.getMovementType();
        if (movementType == MovementType.CAPTURE) {
            throw new UnsupportedOperationException("Does not support CAPTURE yet");
        }
        
        boolean blackStartsAtNorth = details.getBlackStartsAtNorth();
        Position currentPosition = details.getCurrentPosition();
        Position newPosition = details.getNewPosition();
        
        if (blackStartsAtNorth) {
            return canMoveSouthToPosition(currentPosition, newPosition);
        }
        return canMoveNorthToPosition(currentPosition, newPosition);
    }

    private boolean canMoveSouthToPosition(Position currentPosition, Position newPosition) {
        return (currentPosition.getX() == newPosition.getX()) 
                && (currentPosition.getY() - newPosition.getY() == 1);
    }

    private boolean canMoveNorthToPosition(Position currentPosition, Position newPosition) {
        return (currentPosition.getX() == newPosition.getX()) 
                && (currentPosition.getY() - newPosition.getY() == -1);
    }

}
