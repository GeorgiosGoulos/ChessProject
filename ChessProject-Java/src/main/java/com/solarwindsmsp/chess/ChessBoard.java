package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.chesspiece.ChessPiece;
import com.solarwindsmsp.chess.chesspiece.Position;

public class ChessBoard {

    public static final int MAX_BOARD_WIDTH = 7;
    public static final int MAX_BOARD_HEIGHT = 7;

    public static final int WIDTH_INVALID_INDEX = -1;
    public static final int HEIGHT_INVALID_INDEX = -1;

    private ChessPiece[][] pieces;

    private boolean blackStartsAtNorth;

    public ChessBoard() {
        this(true);
    }

    public ChessBoard(boolean blackStartsAtNorth) {
        pieces = new ChessPiece[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
        this.blackStartsAtNorth = blackStartsAtNorth;
    }

    public boolean blackStartsAtNorth() {
        return blackStartsAtNorth;
    }
    
    public void add(ChessPiece piece, Position position) {
        if (!(isLegalBoardPosition(position)
                && positionIsAvailable(position)
                && canAddMorePieces(piece))) {
            placePieceToInvalidPosition(piece);
            return;
        }
        pieces[position.getX()][position.getY()] = piece;
        piece.setPosition(position);
    }

    /**
     * @deprecated use {@link com.solarwindsmsp.chess.ChessBoard#add(ChessPiece, Position)} instead
     * 
     * Adds the piece to the specified coordinates
     * 
     * @param piece the piece to add
     * @param xCoordinate x coordinate
     * @param yCoordinate y coordinate
     */
    @Deprecated
    public void add(ChessPiece piece, int xCoordinate, int yCoordinate) {
        Position position = new Position(xCoordinate, yCoordinate);
        add(piece, position);
    }

    public void remove(ChessPiece piece) {
        int xCoordinate = piece.getXCoordinate();
        int yCoordinate = piece.getYCoordinate();
        pieces[xCoordinate][yCoordinate] = null;
        piece.setXCoordinate(-1);
        piece.setYCoordinate(-1);
    }

    private void placePieceToInvalidPosition(ChessPiece piece) {
        piece.setXCoordinate(WIDTH_INVALID_INDEX);
        piece.setYCoordinate(HEIGHT_INVALID_INDEX);
    }

    public boolean positionIsAvailable(Position position) {
        return pieces[position.getX()][position.getY()] == null;
    }

    /**
     * @deprecated use {@link com.solarwindsmsp.chess.ChessBoard#isLegalBoardPosition(Position)} instead
     * 
     * Checks whether the provided coordinates corresponse to a valid position on the board
     * 
     * @param xCoordinate x coordinate
     * @param yCoordinate y coordinate
     * @return <tt>true</tt> if the position exists on the board, otherwise <tt>false</tt>
     */
    @Deprecated
    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return isLegalXCoordinate(xCoordinate) && isLegalYCoordinate(yCoordinate);
    }

    /**
     * 
     * Checks whether the provided position exists on the board
     * 
     * @param position the position in question
     * @return <tt>true</tt> if the position exists on the board, otherwise <tt>false</tt>
     */
    public boolean isLegalBoardPosition(Position position) {
        return isLegalXCoordinate(position.getX()) && isLegalYCoordinate(position.getY());
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
}
