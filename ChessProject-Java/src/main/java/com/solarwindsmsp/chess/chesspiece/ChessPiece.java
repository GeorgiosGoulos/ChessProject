package com.solarwindsmsp.chess.chesspiece;

public abstract class ChessPiece implements MovementStrategy {

    protected PieceColor pieceColor;

    public ChessPiece(PieceColor color) {
        this.pieceColor = color;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    /**
     * Returns the maximum number of permitted pieces for this instance's type and
     * {@link com.solarwindsmsp.chess.chesspiece.PieceColor PieceColor} on the chess board
     * 
     * @return the maximum number of permitted pieces
     */
    public abstract int getMaxNumberOfPiecesAllowed();

    /**
     * Compares the two instances based on the following attributes:
     * <p>
     * <ul>
     * <li>Runtime class</li>
     * <li>Color</li>
     * </ul>
     *
     * @param obj
     * @return <tt>true</tt> if the instances have the same values for the aforementioned attributes, otherwise <tt>false</tt>
     */
    public boolean isOfSameType(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ChessPiece other = (ChessPiece) obj;
        return pieceColor == other.pieceColor;
    }

}
