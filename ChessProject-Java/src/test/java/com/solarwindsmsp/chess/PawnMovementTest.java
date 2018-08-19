package com.solarwindsmsp.chess;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import com.solarwindsmsp.chess.chesspiece.MovementDetails;
import com.solarwindsmsp.chess.chesspiece.MovementType;
import com.solarwindsmsp.chess.chesspiece.Pawn;
import com.solarwindsmsp.chess.chesspiece.PieceColor;
import com.solarwindsmsp.chess.chesspiece.Position;

public class PawnMovementTest {

    private Pawn testee;
    private MovementType movementType = MovementType.MOVE;

    @Before
    public void setUp() {
        this.testee = new Pawn(PieceColor.BLACK);
    }
    
    @Test
    public void canMoveToPosition_whenMovesNorthByOneAndBlackStartsSouth_returnsTrue() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(false)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(1, 2))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isTrue();
    }
    
    @Test
    public void canMoveToPosition_whenMovesNorthByTwoAndBlackStartsSouth_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(false)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(1, 3))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesWestByOne_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(false)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(0, 1))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesEastByOne_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(false)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(2, 1))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesNorthAndWestByOne_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(false)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(0, 2))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesSouthByOneAndBlackStartsAtNorth_returnsTrue() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(new Position(1, 1))
                .newPosition(new Position(1, 0))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isTrue();
    }
    
    @Test
    public void canMoveToPosition_whenMovesSouthByTwoAndBlackStartsAtNorth_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(new Position(1, 2))
                .newPosition(new Position(1, 0))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesWestByOneAndBlackStartsAtNorth_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(new Position(1, 2))
                .newPosition(new Position(0, 2))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void canMoveToPosition_whenMovesEastByOneAndBlackStartsAtNorth_returnsFalse() {
        // Given
        MovementDetails movementDetails = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(new Position(1, 2))
                .newPosition(new Position(2, 2))
                .movementType(movementType)
                .build();

        // When
        boolean result = testee.canMoveToPosition(movementDetails);

        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    
}