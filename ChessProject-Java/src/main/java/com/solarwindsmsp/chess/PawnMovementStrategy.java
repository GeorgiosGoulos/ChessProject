package com.solarwindsmsp.chess;

public class PawnMovementStrategy implements MovementStrategy {
    
    public void moveToPosition(Pawn pawn, int xNewCoordinate, int yNewCoordinate) {
        if (!canMoveToPosition(pawn, xNewCoordinate, yNewCoordinate)) {
            return;
        }
        pawn.getChessBoard().remove(pawn);
        pawn.getChessBoard().add(pawn, xNewCoordinate, yNewCoordinate, pawn.getPieceColor());
    }

    private boolean canMoveToPosition(Pawn pawn, int xNewCoordinate,
            int yNewCoordinate) {
        if (pawn == null || pawn.getChessBoard() == null) {
            return false;
        }
        ChessBoard chessBoard = pawn.getChessBoard();
        // Verify pawn is on the chess board
        if (pawn.getXCoordinate() == ChessBoard.WIDTH_INVALID_INDEX && pawn.getYCoordinate() == ChessBoard.HEIGHT_INVALID_INDEX) {
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
            return canMoveSouthToPosition(pawn.getXCoordinate(), pawn.getYCoordinate(), xNewCoordinate, yNewCoordinate);
        }
        return canMoveNorthToPosition(pawn.getXCoordinate(), pawn.getYCoordinate(), xNewCoordinate, yNewCoordinate);
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
