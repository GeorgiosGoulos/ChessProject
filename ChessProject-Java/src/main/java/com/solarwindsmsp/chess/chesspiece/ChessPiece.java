package com.solarwindsmsp.chess.chesspiece;

import java.text.MessageFormat;
import com.solarwindsmsp.chess.ChessBoard;

public abstract class ChessPiece implements MovementStrategy {

    protected ChessBoard chessBoard;
    protected Position position;
    protected PieceColor pieceColor;

    public ChessPiece(PieceColor color) {
        this.pieceColor = color;
        this.position = new Position(-1, -1);
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return position.getX();
    }

    public void setXCoordinate(int xCoordinate) {
        this.position.setX(xCoordinate);
    }

    public int getYCoordinate() {
        return this.getPosition().getY();
    }

    public void setYCoordinate(int yCoordinate) {
        this.position.setY(yCoordinate);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
    
    /*
     * Wrapper of 
     */
    public boolean move(MovementType movementType, int newX, int newY) {
        Position newPosition = new Position(newX, newY);
        return move(movementType, newPosition);
    }
    
    public abstract boolean move(MovementType movementType, Position newPosition);

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    private String currentPositionAsString() {
        String eol = System.lineSeparator();
        return MessageFormat.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}",
                eol, this.position.getX(), this.position.getY(), pieceColor);
    }

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
