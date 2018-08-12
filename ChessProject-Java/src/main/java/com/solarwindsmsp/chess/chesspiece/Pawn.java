package com.solarwindsmsp.chess.chesspiece;

import com.solarwindsmsp.chess.ChessBoard;

public class Pawn extends ChessPiece {

    private static final int MAX_NUMBER_OF_PIECES = ChessBoard.MAX_BOARD_WIDTH;

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (movementType == MovementType.MOVE) {
            moveToPosition(newX, newY);
        }
    }

    @Override
    public int getMaxNumberOfPiecesAllowed() {
        return MAX_NUMBER_OF_PIECES;
    }

    @Override
    public void moveToPosition(int xNewCoordinate, int yNewCoordinate) {
        if (!canMoveToPosition(xNewCoordinate, yNewCoordinate)) {
            return;
        }
        getChessBoard().remove(this);
        getChessBoard().add(this, xNewCoordinate, yNewCoordinate);
    }

    private boolean canMoveToPosition(int xNewCoordinate,
            int yNewCoordinate) {
        if (getChessBoard() == null) {
            return false;
        }
        ChessBoard chessBoard = getChessBoard();
        // Verify pawn is on the chess board
        if (getXCoordinate() == ChessBoard.WIDTH_INVALID_INDEX && getYCoordinate() == ChessBoard.HEIGHT_INVALID_INDEX) {
            return false;
        }
        // Validate new position
        if (!chessBoard.isLegalBoardPosition(xNewCoordinate, yNewCoordinate)) {
            return false;
        }
        // Validate position is available
        if (!chessBoard.positionIsAvailable(xNewCoordinate, yNewCoordinate)) {
            return false;
        }
        if (chessBoard.blackStartsAtNorth()) {
            return canMoveSouthToPosition(getXCoordinate(), getYCoordinate(), xNewCoordinate, yNewCoordinate);
        }
        return canMoveNorthToPosition(getXCoordinate(), getYCoordinate(), xNewCoordinate, yNewCoordinate);
    }

    private boolean canMoveSouthToPosition(int xCoordinate, int yCoordinate, int xNewCoordinate,
            int yNewCoordinate) {
        return (xCoordinate == xNewCoordinate) && (yCoordinate - yNewCoordinate == 1);
    }
    
    private boolean canMoveNorthToPosition(int xCoordinate, int yCoordinate, int xNewCoordinate,
            int yNewCoordinate) {
        return (xCoordinate == xNewCoordinate) && (yCoordinate - yNewCoordinate == -1);
    }
}
