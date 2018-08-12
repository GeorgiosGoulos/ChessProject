package com.solarwindsmsp.chess.chesspiece;

interface MovementStrategy {
    
    void moveToPosition(int xNewCoordinate, int yNewCoordinate);
}
