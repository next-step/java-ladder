package nextstep.ladder.model.ladder;

import java.util.Objects;

public class Position {
    private final int index;
    
    public Position(final int index) {
        validatePosition(index);
        this.index = index;
    }
    
    private void validatePosition(final int index) {
        if (index < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다: " + index);
        }
    }
    
    public Position moveLeft() {
        if (index == 0) {
            return this;
        }
        return new Position(index - 1);
    }
    
    public Position moveRight() {
        return new Position(index + 1);
    }

    public int getIndex() {
        return index;
    }
    
    public boolean isValid(final int maxPosition) {
        return index >= 0 && index < maxPosition;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return index == position.index;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
} 
