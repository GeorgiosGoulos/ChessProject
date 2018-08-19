package com.solarwindsmsp.chess.chesspiece;

import java.util.Objects;

public class MovementDetails {

    private MovementType movementType;
    private Position currentPosition;
    private Position newPosition;
    private Boolean blackStartsAtNorth;

    private MovementDetails(MovementType movementType, Position currentPosition,
            Position newPosition, Boolean blackStartsAtNorth) {
        this.movementType = movementType;
        this.currentPosition = currentPosition;
        this.newPosition = newPosition;
        this.blackStartsAtNorth = blackStartsAtNorth;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public Boolean getBlackStartsAtNorth() {
        return blackStartsAtNorth;
    }

    public static class Builder {
        private MovementType movementType;
        private Position currentPosition;
        private Position newPosition;
        private Boolean blackStartsAtNorth;

        public Builder movementType(MovementType movementType) {
            this.movementType = movementType;
            return this;
        }

        public Builder currentPosition(Position currentPosition) {
            this.currentPosition = currentPosition;
            return this;
        }

        public Builder newPosition(Position newPosition) {
            this.newPosition = newPosition;
            return this;
        }

        public Builder blackStartsAtNorth(Boolean blackStartsAtNorth) {
            this.blackStartsAtNorth = blackStartsAtNorth;
            return this;
        }

        public MovementDetails build() {
            Objects.requireNonNull(currentPosition);
            Objects.requireNonNull(newPosition);
            Objects.requireNonNull(movementType);
            Objects.requireNonNull(blackStartsAtNorth);
            return new MovementDetails(movementType, currentPosition, newPosition, blackStartsAtNorth);
        }

    }
}
