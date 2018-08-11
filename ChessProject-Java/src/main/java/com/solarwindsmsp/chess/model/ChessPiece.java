package com.solarwindsmsp.chess.model;

import com.solarwindsmsp.chess.ChessBoard;

public abstract class ChessPiece {

    protected ChessBoard chessBoard;
    protected int xCoordinate;
    protected int yCoordinate;
    protected Point point;
    protected PieceColor pieceColor;
    protected MovementStrategy movementStrategy;

    public ChessPiece(PieceColor color) {
        this.pieceColor = color;
        this.point = new Point(0, 0);
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



    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    /**
     * Returns the maximum number of permitted pieces such as this one on the chess board, taking
     * into account the piece type and color
     * 
     * @return the maximum number of permitted pieces
     */
    public abstract int getMaxNumberOfPiecesAllowed();

}
