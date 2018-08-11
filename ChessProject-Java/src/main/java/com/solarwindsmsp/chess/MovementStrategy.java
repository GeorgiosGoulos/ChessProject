package com.solarwindsmsp.chess;

public interface MovementStrategy {
    
    void moveToPosition(Pawn pawn, int xNewCoordinate, int yNewCoordinate);
}
