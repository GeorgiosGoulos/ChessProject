package com.solarwindsmsp.chess.chesspiece;

interface MovementStrategy {
    
    /**
     * Moves the pawn to the new position if that position is available.
     * Otherwise, does nothing.
     * @param position the new position to move to
     * @return TODO
     */
    boolean moveToPosition(Position position);
}
