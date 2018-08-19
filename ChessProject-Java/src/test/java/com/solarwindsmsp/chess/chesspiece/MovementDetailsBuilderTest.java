package com.solarwindsmsp.chess.chesspiece;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MovementDetailsBuilderTest {
    
    private static final int CURRENT_POSITION_X = 0;
    private static final int CURRENT_POSITION_Y = 0;
    private static final int NEW_POSITION_X = 1;
    private static final int NEW_POSITION_Y = 1;

    @Test(expected = NullPointerException.class)
    public void build_whenCurrentPositionIsNull_throwsNullPointerException() {
        // Given
        MovementDetails.Builder builder = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(null)
                .newPosition(getNewPosition())
                .movementType(MovementType.MOVE);
        
        // When
        builder.build();
        
        // Then exception is thrown
        Assertions.fail("NullPointerException expected");
    }
    
    @Test(expected = NullPointerException.class)
    public void build_whenNewPositionIsNull_throwsNullPointerException() {
        // Given
        MovementDetails.Builder builder = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(getCurrentPosition())
                .newPosition(null)
                .movementType(MovementType.MOVE);
        
        // When
        builder.build();
        
        // Then exception is thrown
        Assertions.fail("NullPointerException expected");
    }
    
    @Test(expected = NullPointerException.class)
    public void build_whenMovementTypeIsNull_throwsNullPointerException() {
        // Given
        MovementDetails.Builder builder = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(getCurrentPosition())
                .newPosition(getNewPosition())
                .movementType(null);
        
        // When
        builder.build();
        
        // Then exception is thrown
        Assertions.fail("NullPointerException expected");
    }
    
    @Test(expected = NullPointerException.class)
    public void build_whenBlackStartsAtNorthIsNull_throwsNullPointerException() {
        // Given
        MovementDetails.Builder builder = new MovementDetails.Builder()
                .blackStartsAtNorth(null)
                .currentPosition(getCurrentPosition())
                .newPosition(getNewPosition())
                .movementType(MovementType.MOVE);
        
        // When
        builder.build();
        
        // Then exception is thrown
        Assertions.fail("NullPointerException expected");
    }
    
    @Test
    public void build_whenAllFieldsAreProvided_returnsPaymentDetails() {
        // Given
        MovementDetails.Builder builder = new MovementDetails.Builder()
                .blackStartsAtNorth(true)
                .currentPosition(getCurrentPosition())
                .newPosition(getNewPosition())
                .movementType(MovementType.MOVE);
        
        // When
        MovementDetails details = builder.build();
        
        // Then exception is thrown
        Assertions.assertThat(details).isNotNull();
    }
    
    private Position getCurrentPosition() {
        return new Position(CURRENT_POSITION_X, CURRENT_POSITION_Y);
    }
    
    private Position getNewPosition() {
        return new Position(NEW_POSITION_X, NEW_POSITION_Y);
    }

}
