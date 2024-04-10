package ladder.domain;

import java.util.Objects;

public class Position {
    private final int height;
    private final int width;

    public Position(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public static Position departurePosition(int indexOfParticipant) {
        return new Position(0, indexOfParticipant);
    }

    public Position moveLeftAndDown() {
        return new Position(height + 1, width - 1);
    }

    public Position moveRightAndDown() {
        return new Position(height + 1, width + 1);
    }

    public Position moveDown() {
        return new Position(height + 1, width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isArrivalPosition(int ladderHeight) {
        return this.height >= ladderHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return height == position.height && width == position.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
