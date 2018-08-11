package com.solarwindsmsp.chess.model;

import com.solarwindsmsp.chess.ChessBoard;

public abstract class ChessPiece {

    protected ChessBoard chessBoard;
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
        return point.getX();
    }

    public void setXCoordinate(int xCoordinate) {
        this.point.setX(xCoordinate);
    }

    public int getYCoordinate() {
        return this.getPoint().getY();
    }

    public void setYCoordinate(int yCoordinate) {
        this.point.setY(yCoordinate);
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
     * Returns the maximum number of permitted pieces for this instance's type and
     * {@link com.solarwindsmsp.chess.model.PieceColor PieceColor} on the chess board
     * 
     * @return the maximum number of permitted pieces
     */
    public abstract int getMaxNumberOfPiecesAllowed();

}
