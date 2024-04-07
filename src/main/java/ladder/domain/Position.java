package ladder.domain;

import java.util.Objects;

public class Position {
    private int height;
    private int width;

    public Position(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Position moveLeftAndDown() {
        this.width--;
        this.moveDown();
        return this;
    }

    public Position moveRightAndDown() {
        this.width++;
        this.moveDown();
        return this;
    }

    public Position moveDown() {
        this.height++;
        return this;
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
