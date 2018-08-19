package com.solarwindsmsp.chess.chesspiece;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ChessPieceTest {
    
    private ChessPiece testee;
    
    @Before
    public void setup() {
        testee = new MockChessPiece(PieceColor.BLACK);
    }

    @Test
    public void isOfSameType_whenOtherObjectIsNull_returnFalse() {
        // Given
        ChessPiece mockChessPiece = null;
        
        // When
        boolean result = testee.isOfSameType(mockChessPiece);
        
        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isOfSameType_whenOtherObjectHasDifferentColor_returnFalse() {
        // Given
        ChessPiece mockChessPiece = new MockChessPiece(PieceColor.WHITE);
        
        // When
        boolean result = testee.isOfSameType(mockChessPiece);
        
        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isOfSameType_whenOtherObjectIsOfDifferentSubclassButHasSameColor_returnFalse() {
        // Given
        ChessPiece mockChessPiece = new MockChessPiece2(PieceColor.BLACK);
        
        // When
        boolean result = testee.isOfSameType(mockChessPiece);
        
        // Then
        Assertions.assertThat(result).isFalse();
    }
    
    @Test
    public void isOfSameType_whenOtherObjectIsOfSameSubclassAndColor_returnTrue() {
        // Given
        ChessPiece mockChessPiece = new MockChessPiece(PieceColor.BLACK);
        
        // When
        boolean result = testee.isOfSameType(mockChessPiece);
        
        // Then
        Assertions.assertThat(result).isTrue();
    }
    
    @Test
    public void isOfSameType_whenSameObject_returnTrue() {
        // Given
        ChessPiece mockChessPiece = testee;
        
        // When
        boolean result = testee.isOfSameType(mockChessPiece);
        
        // Then
        Assertions.assertThat(result).isTrue();
    }

}
