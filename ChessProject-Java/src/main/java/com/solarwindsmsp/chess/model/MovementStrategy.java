package com.solarwindsmsp.chess.model;

public interface MovementStrategy {
    
    void moveToPosition(Pawn pawn, int xNewCoordinate, int yNewCoordinate);
}
