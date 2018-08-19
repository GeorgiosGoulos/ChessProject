package com.solarwindsmsp.chess.chesspiece;

interface MovementStrategy {
    
    /**
     * 
     * Indicates whether an instance of the {@link com.solarwindsmsp.chess.chesspiece.ChessPiece ChessPiece} class 
     * can perform the specified movement between the given positions.
     * 
     * @param details details specifying the movement to be performed
     * @return <tt>true</tt> is the piece can move from the current position to the new position 
     * performing the specified movement, otherwise <tt>false</tt>
     */
    boolean canMoveToPosition(MovementDetails details);
}
