package com.solarwindsmsp.chess.chesspiece;

interface MovementStrategy {
    
    /**
     * Moves the pawn to the new position if that position is available.
     * Otherwise, does nothing.
     * @param xNewCoordinate
     * @param yNewCoordinate
     */
    void moveToPosition(int xNewCoordinate, int yNewCoordinate);
}
