package com.solarwindsmsp.chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.solarwindsmsp.chess.chesspiece.ChessPiece;
import com.solarwindsmsp.chess.chesspiece.MovementDetails;
import com.solarwindsmsp.chess.chesspiece.MovementType;
import com.solarwindsmsp.chess.chesspiece.Position;

public class ChessBoard implements ChessBoardActions {
    
    private static final Logger logger = LoggerFactory.getLogger(ChessBoard.class);

    public static final int MAX_BOARD_WIDTH = 7;
    public static final int MAX_BOARD_HEIGHT = 7;
    
    public static final int INVALID_WIDTH_POSITION = -1;
    public static final int INVALID_HEIGHT_POSITION = -1;

    private ChessPiece[][] pieces;

    private boolean blackAtNorth;

    public ChessBoard() {
        this(true);
    }

    public ChessBoard(boolean blackAtNorth) {
        pieces = new ChessPiece[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
        this.blackAtNorth = blackAtNorth;
    }
    
    @Override
    public boolean isLegalBoardPosition(Position position) {
        return position != null
                && isLegalXCoordinate(position.getX())
                && isLegalYCoordinate(position.getY());
    }

    @Override
    public Position getPosition(ChessPiece piece) {
        for (int i = 0; i <= MAX_BOARD_WIDTH; i++) {
            for (int j = 0; j <= MAX_BOARD_HEIGHT; j++) {
                if (pieces[i][j] != null && pieces[i][j].equals(piece)) {
                    return new Position(i, j);
                }
            }
        }
        return new Position(INVALID_WIDTH_POSITION, INVALID_HEIGHT_POSITION);
    }

    @Override
    public boolean add(ChessPiece piece, Position position) {
        if (piece != null
                && isLegalBoardPosition(position) 
                && positionIsAvailable(position)
                && !pieceIsOnTheBoard(piece)
                && canAddMorePieces(piece)) {
            setPieceToPosition(position, piece);
            return true;
        }
        return false;
    }

    @Override
    public boolean move(ChessPiece piece, MovementType movementType, Position newPosition) {
        if (!pieceIsOnTheBoard(piece)) {
            logger.warn("piece {} is not on the board", piece);
            return false;
        }
        Position currentPosition = getPosition(piece);
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(isBlackAtNorth())
                .currentPosition(currentPosition)
                .newPosition(newPosition)
                .movementType(movementType)
                .build();
        if (isLegalBoardPosition(newPosition)
                && piece.canMoveToPosition(movementDetails)) {
            removeFromPosition(currentPosition);
            addOrReplace(piece, newPosition);
            return true;
        }
        return false;
    }

    private boolean positionIsAvailable(Position position) {
        if (!isLegalBoardPosition(position)) {
            return false;
        }
        return pieces[position.getX()][position.getY()] == null;
    }

    /**
     * Indicates which side of the {@link com.solarwindsmsp.chess.ChessBoard ChessBoard}
     * the Black player starts at.
     *  
     * @return <tt>true</tt> is the Black player start at the North side, or <tt>false</tt> 
     * if it is the South side
     */
    private boolean isBlackAtNorth() {
        return blackAtNorth;
    }

    private void removeFromPosition(Position position) {
        setPieceToPosition(position, null);
    }

    private void addOrReplace(ChessPiece piece, Position position) {
        if (isLegalBoardPosition(position) 
                && !pieceIsOnTheBoard(piece)
                && canAddMorePieces(piece)) {
            setPieceToPosition(position, piece);
        }
    }

    private void setPieceToPosition(Position position, ChessPiece piece) {
        if (position != null) {
            pieces[position.getX()][position.getY()] = piece;
        }
    }

    private boolean isLegalXCoordinate(int xCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= MAX_BOARD_WIDTH;
    }

    private boolean isLegalYCoordinate(int yCoordinate) {
        return yCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT;
    }

    private boolean canAddMorePieces(ChessPiece piece) {
        int number = getNumberOfExistingPieces(piece);
        return number < piece.getMaxNumberOfPiecesAllowed();
    }

    private int getNumberOfExistingPieces(ChessPiece piece) {
        int numberOfPiecess = 0;
        for (int i = 0; i <= MAX_BOARD_HEIGHT; i++) {
            for (int j = 0; j <= MAX_BOARD_WIDTH; j++) {
                if (pieces[i][j] != null && pieces[i][j].isOfSameType(piece)) {
                    numberOfPiecess++;
                }
            }
        }
        return numberOfPiecess;
    }

    private boolean pieceIsOnTheBoard(ChessPiece piece) {
        return !getPosition(piece).equals(new Position(INVALID_WIDTH_POSITION, INVALID_HEIGHT_POSITION));
    }
}
