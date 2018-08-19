package com.solarwindsmsp.chess.chesspiece;

/**
 * Indicates a position on the ChessBoard
 *
 */
public class Position {

    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", getX(), getY());
    }

}
