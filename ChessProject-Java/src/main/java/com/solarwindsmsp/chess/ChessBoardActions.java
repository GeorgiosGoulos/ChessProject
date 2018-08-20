package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.chesspiece.ChessPiece;
import com.solarwindsmsp.chess.chesspiece.MovementType;
import com.solarwindsmsp.chess.chesspiece.Position;

public interface ChessBoardActions {
    
    /**
     * 
     * Checks whether the provided position exists on the board
     * 
     * @param position the position in question
     * @return <tt>true</tt> if the position exists on the board, otherwise <tt>false</tt>
     */
    public boolean isLegalBoardPosition(Position position);

    /**
     * Retrieves the {@link com.solarwindsmsp.chess.chesspiece.Position Position} of a 
     * {@link com.solarwindsmsp.chess.chesspiece.ChessPiece ChessPiece} on the board
     * @param piece the piece in question
     * @return The Position of the piece. If the piece is on the board the Position 
     * ({@link com.solarwindsmsp.chess.ChessBoard#INVALID_WIDTH_POSITION INVALID_WIDTH_POSITION})
     * ({@link com.solarwindsmsp.chess.ChessBoard#INVALID_HEIGHT_POSITION INVALID_HEIGHT_POSITION})
     * is returned instead
     */
    public Position getPosition(ChessPiece piece);

    /**
     * Places a {@link com.solarwindsmsp.chess.chesspiece.ChessPiece ChessPiece} 
     * to a specified {@link com.solarwindsmsp.chess.chesspiece.Position Position}  
     * 
     * @param piece the piece to be placed
     * @param position the position at which the piece should be placed
     * @return <tt>true</tt> if the piece was placed, or <tt>false</tt> if the piece could not be added
     */
    public boolean add(ChessPiece piece, Position position);

    /**
     * Moves a {@link com.solarwindsmsp.chess.chesspiece.ChessPiece ChessPiece} 
     * to a specified {@link com.solarwindsmsp.chess.chesspiece.Position Position}
     * @param piece the piece to be moved
     * @param movementType the {@link com.solarwindsmsp.chess.chesspiece.MovementType MovementType}. Can be MOVE or CAPTURE
     * @param newPosition the position to move the piece to
     * @return <tt>true</tt> if the piece was moved, or <tt>false</tt> if the operation failed
     */
    public boolean move(ChessPiece piece, MovementType movementType, Position newPosition);
    
}
