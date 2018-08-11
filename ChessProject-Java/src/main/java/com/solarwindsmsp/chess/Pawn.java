package com.solarwindsmsp.chess;

import java.text.MessageFormat;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;
    public static final int MAX_NUMBER_OF_PIECES = ChessBoard.MAX_BOARD_WIDTH;
    private MovementStrategy movementStrategy = new PawnMovementStrategy();

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
       movementStrategy.moveToPosition(this, newX, newY);
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        String eol = System.lineSeparator();
        return MessageFormat.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
