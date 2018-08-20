package com.solarwindsmsp.chess;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.solarwindsmsp.chess.chesspiece.ChessPiece;
import com.solarwindsmsp.chess.chesspiece.MovementDetails;
import com.solarwindsmsp.chess.chesspiece.MovementType;
import com.solarwindsmsp.chess.chesspiece.Pawn;
import com.solarwindsmsp.chess.chesspiece.Position;

/**
 * Contains tests for the ChessBoard class based on its behavior
 *
 */
public class ChessBoardActionsTest {

    private ChessBoardActions testee;
    
    private static final int VALID_X = 0;
    private static final int VALID_Y = 0;

    private static final int VALID_X_2 = 4;
    private static final int VALID_Y_2 = 5;

    private static final int LARGE_NUMBER_OF_PIECES_ALLOWED = 10;


    @Before
    public void setup() {
        testee = new ChessBoard();
    }
    
    @Test
    public void isLegalBoardPosition_whenPositionOnTheBoard_returnsTrue() {
        // Given
        Position position = new Position(VALID_X,VALID_Y);

        // When
        boolean result = testee.isLegalBoardPosition(position);

        // Then
        Assertions.assertThat(result).isTrue();
    }
    
    @Test
    public void isLegalBoardPosition_whenPositionToTheNorthOfTheBoard_returnsFalse() {
        // Given
        Position position = new Position(VALID_X,ChessBoard.MAX_BOARD_HEIGHT + 1);

        // When
        boolean result = testee.isLegalBoardPosition(position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isLegalBoardPosition_whenPositionToTheSouthOfTheBoard_returnsFalse() {
        // Given
        Position position = new Position(VALID_X, - 1);

        // When
        boolean result = testee.isLegalBoardPosition(position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isLegalBoardPosition_whenPositionToTheWestOfTheBoard_returnsFalse() {
        // Given
        Position position = new Position(-1, VALID_Y);

        // When
        boolean result = testee.isLegalBoardPosition(position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isLegalBoardPosition_whenPositionToTheEastOfTheBoard_returnsFalse() {
        // Given
        Position position = new Position(ChessBoard.MAX_BOARD_WIDTH + 1, VALID_Y);

        // When
        boolean result = testee.isLegalBoardPosition(position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void getPosition_whenPieceIsNotOnTheBoard_returnsInvalidPosition() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();

        // When
        Position result = testee.getPosition(mockPiece);

        // Then
        Assertions.assertThat(result.getX()).isEqualTo(ChessBoard.INVALID_WIDTH_POSITION);
        Assertions.assertThat(result.getY()).isEqualTo(ChessBoard.INVALID_HEIGHT_POSITION);
    }
    
    @Test
    public void getPosition_whenPieceIsOnTheBoard_returnsPosition() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        testee.add(mockPiece, new Position(VALID_X, VALID_Y));

        // When
        Position result = testee.getPosition(mockPiece);

        // Then
        Assertions.assertThat(result.getX()).isEqualTo(VALID_X);
        Assertions.assertThat(result.getY()).isEqualTo(VALID_Y);
    }
    
    @Test
    public void add_whenPieceIsNull_returnsFalse() {
        // Given
        Pawn pawn = null;
        Position position = new Position(VALID_X, VALID_Y);

        // When
        boolean result = testee.add(pawn, position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void add_whenPositionIsNull_returnsFalse() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        Position position = null;

        // When
        boolean result = testee.add(mockPiece, position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void add_whenPositionIsInvalid_returnsFalse() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        Position position = new Position(VALID_X, ChessBoard.INVALID_HEIGHT_POSITION);

        // When
        boolean result = testee.add(mockPiece, position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void add_whenPositionIsAvailable_returnsTrue() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        Position position = new Position(VALID_X, VALID_Y);

        // When
        boolean result = testee.add(mockPiece, position);

        // Then
        Assertions.assertThat(result).isTrue();
    }
    
    @Test
    public void add_whenPositionIsAvailableButCannotAddMorePiecesOfSameType_returnsFalse() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere(0);
        Position position = new Position(VALID_X, VALID_Y);

        // When
        boolean result = testee.add(mockPiece, position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void add_whenPositionIsNotAvailable_returnsFalse() {
        // Given
        ChessPiece mockPiece1 = getMockPieceThatCanMoveAnywhere();
        Position position = new Position(VALID_X, VALID_Y);
        ChessPiece mockPiece2 = getMockPieceThatCanMoveAnywhere();
        testee.add(mockPiece1, position);

        // When
        boolean result = testee.add(mockPiece2, position);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void add_whenPieceIsAlreadyOnTheBoard_returnsFalse() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        Position position1 = new Position(VALID_X, VALID_Y);
        Position position2 = new Position(VALID_X_2, VALID_Y_2);
        testee.add(mockPiece, position2);

        // When
        boolean result = testee.add(mockPiece, position1);

        // Then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void move_whenPieceIsNotOnTheBoard_returnsFalse() {
        // Given
        Pawn mockPawn = Mockito.mock(Pawn.class);
        Position position = new Position(VALID_X, VALID_Y);
        Mockito.doReturn(true).when(mockPawn).canMoveToPosition(Mockito.any(MovementDetails.class));

        // When
        boolean result = testee.move(mockPawn, MovementType.MOVE, position);

        // Then
        Assertions.assertThat(result).isEqualTo(false);
    }
    
    @Test
    public void move_whenPieceIsOnTheBoard_returnsTrue() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCanMoveAnywhere();
        Position position = new Position(VALID_X, VALID_Y);
        testee.add(mockPiece, position);

        // When
        boolean result = testee.move(mockPiece, MovementType.MOVE, position);

        // Then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void move_whenPieceCannotMoveToPosition_returnsFalse() {
        // Given
        ChessPiece mockPiece = getMockPieceThatCannotMoveAnywhere();
        Position position = new Position(VALID_X, VALID_Y);
        testee.add(mockPiece, position);

        // When
        boolean result = testee.move(mockPiece, MovementType.MOVE, position);

        // Then
        Assertions.assertThat(result).isEqualTo(false);
    }


    private ChessPiece getMockPieceThatCanMoveAnywhere(int numberOfAllowedPieces) {
        ChessPiece mockPiece = Mockito.mock(ChessPiece.class);
        Mockito.doReturn(true).when(mockPiece).canMoveToPosition(Mockito.any(MovementDetails.class));
        Mockito.doReturn(numberOfAllowedPieces).when(mockPiece).getMaxNumberOfPiecesAllowed();
        return mockPiece;
    }

    private ChessPiece getMockPieceThatCanMoveAnywhere() { 
        return getMockPieceThatCanMoveAnywhere(LARGE_NUMBER_OF_PIECES_ALLOWED);
    }
    
    private ChessPiece getMockPieceThatCannotMoveAnywhere() {
        ChessPiece mockPiece = Mockito.mock(ChessPiece.class);
        Mockito.doReturn(false).when(mockPiece).canMoveToPosition(Mockito.any(MovementDetails.class));
        Mockito.doReturn(LARGE_NUMBER_OF_PIECES_ALLOWED).when(mockPiece).getMaxNumberOfPiecesAllowed();
        return mockPiece;
    }

}
