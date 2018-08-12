package com.solarwindsmsp.chess;

import com.solarwindsmsp.chess.model.ChessPiece;
import com.solarwindsmsp.chess.model.PieceColor;

public class ChessBoard {

    public static final int MAX_BOARD_WIDTH = 7;
    public static final int MAX_BOARD_HEIGHT = 7;
    
    public static final int WIDTH_INVALID_INDEX = -1;
    public static final int HEIGHT_INVALID_INDEX = -1;

    private ChessPiece[][] pieces;
    
    private boolean blackStartsAtNorth = true;

    public ChessBoard() {
        pieces = new ChessPiece[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }
    
    public boolean blackStartsAtNorth() {
        return blackStartsAtNorth;
    }

    public void add(ChessPiece piece, int xCoordinate, int yCoordinate) {
        if (!(isLegalBoardPosition(xCoordinate, yCoordinate) 
            && positionIsAvailable(xCoordinate, yCoordinate) 
            && canAddMorePieces(piece))) {
          placePieceToInvalidPosition(piece);
          return;
        }
        pieces[xCoordinate][yCoordinate] = piece;
        piece.setXCoordinate(xCoordinate);
        piece.setYCoordinate(yCoordinate);
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

    public boolean positionIsAvailable(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return isLegalXCoordinate(xCoordinate) && isLegalYCoordinate(yCoordinate);
    }

    private boolean isLegalXCoordinate(int xCoordinate) {
        return xCoordinate >= 0 && xCoordinate <= MAX_BOARD_WIDTH;
    }

    private boolean isLegalYCoordinate(int yCoordinate) {
        return yCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT;
    }
    
    private boolean canAddMorePieces(ChessPiece piece) {
      int number = getNumberOfExistingPieces(piece.getPieceColor());
      return number < piece.getMaxNumberOfPiecesAllowed();
    }

    private int getNumberOfExistingPieces(PieceColor color) {
      int numberOfPiecess = 0;
      for (int i = 0; i <= MAX_BOARD_HEIGHT; i++) {
        for (int j = 0; j <= MAX_BOARD_WIDTH; j++) {
          if (pieces[i][j] != null && color == pieces[i][j].getPieceColor()) {
            numberOfPiecess++;
          }
        }
      }
      return numberOfPiecess;
    }
}
