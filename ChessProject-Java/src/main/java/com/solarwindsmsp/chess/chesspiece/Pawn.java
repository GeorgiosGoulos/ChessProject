package com.solarwindsmsp.chess.chesspiece;

import com.solarwindsmsp.chess.ChessBoard;

public class Pawn extends ChessPiece {

    private static final int MAX_NUMBER_OF_PIECES = ChessBoard.MAX_BOARD_WIDTH;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    @Override
    public boolean move(MovementType movementType, Position newPosition) {
        if (movementType == MovementType.MOVE) {
            return moveToPosition(newPosition);
        }
        // Capturing not implemented yet
        return false;
    }

    @Override
    public int getMaxNumberOfPiecesAllowed() {
        return MAX_NUMBER_OF_PIECES;
    }

    @Override
    public boolean moveToPosition(Position newPosition) {
        if (!canMoveToPosition(newPosition)) {
            return false;
        }
        getChessBoard().remove(this);
        getChessBoard().add(this, newPosition);
        return true;
    }

    private boolean canMoveToPosition(Position newPosition) {
        if (getChessBoard() == null) {
            return false;
        }
        ChessBoard chessBoard = getChessBoard();
        // Verify pawn is on the chess board
        if (getXCoordinate() == ChessBoard.WIDTH_INVALID_INDEX && getYCoordinate() == ChessBoard.HEIGHT_INVALID_INDEX) {
            return false;
        }
        // Validate new position
        if (!chessBoard.isLegalBoardPosition(newPosition)) {
            return false;
        }
        // Validate position is available
        if (!chessBoard.positionIsAvailable(newPosition)) {
            return false;
        }
        if (chessBoard.blackStartsAtNorth()) {
            return canMoveSouthToPosition(getPosition(), newPosition);
        }
        return canMoveNorthToPosition(getPosition(), newPosition);
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
