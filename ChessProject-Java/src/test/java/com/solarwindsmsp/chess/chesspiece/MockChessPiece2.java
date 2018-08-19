package com.solarwindsmsp.chess.chesspiece;

/**
 * Mock ChessPiece extending {@link com.solarwindsmsp.chess.chesspiece.ChessPiece ChessPiece}
 * used for testing purposes
 *
 */
class MockChessPiece2 extends ChessPiece {

    public MockChessPiece2(PieceColor color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(MovementDetails details) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getMaxNumberOfPiecesAllowed() {
        // TODO Auto-generated method stub
        return 0;
    }

}
