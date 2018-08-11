package com.solarwindsmsp.chess;

public class ChessBoard {

    public static final int MAX_BOARD_WIDTH = 7;
    public static final int MAX_BOARD_HEIGHT = 7;
    
    public static final int WIDTH_INVALID_INDEX = -1;
    public static final int HEIGHT_INVALID_INDEX = -1;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (!(isLegalBoardPosition(xCoordinate, yCoordinate) 
            && positionIsAvailable(xCoordinate, yCoordinate) 
            && canAddMorePawns(pieceColor))) {
          placePawnToInvalidPosition(pawn);
          return;
        }
        pieces[xCoordinate][yCoordinate] = pawn;
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
    }

    private void placePawnToInvalidPosition(Pawn pawn) {
        pawn.setXCoordinate(WIDTH_INVALID_INDEX);
        pawn.setYCoordinate(HEIGHT_INVALID_INDEX);
    }

    private boolean positionIsAvailable(int xCoordinate, int yCoordinate) {
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
    
    private boolean canAddMorePawns(PieceColor color) {
      int number = getNumberOfExistingPawns(color);
      return number < Pawn.MAX_NUMBER_OF_PIECES;
    }

    private int getNumberOfExistingPawns(PieceColor color) {
      int numberOfPawns = 0;
      for (int i = 0; i <= MAX_BOARD_HEIGHT; i++) {
        for (int j = 0; j <= MAX_BOARD_WIDTH; j++) {
          if (pieces[i][j] != null && color == pieces[i][j].getPieceColor()) {
            numberOfPawns++;
          }
        }
      }
      return numberOfPawns;
    }
}
