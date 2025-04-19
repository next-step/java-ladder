package nextstep.ladder.model.ladder;

import java.util.Objects;

public class Position {
    private final int value;
    
    public Position(final int value) {
        validatePosition(value);
        this.value = value;
    }
    
    private void validatePosition(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다: " + value);
        }
    }
    
    public Position moveLeft() {
        if (value == 0) {
            return this;
        }
        return new Position(value - 1);
    }
    
    public Position moveRight() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }
    
    public boolean isValid(final int maxPosition) {
        return value >= 0 && value < maxPosition;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
} 
