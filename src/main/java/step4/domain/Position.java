package step4.domain;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position moveDown(Lines lines, int h) {
        if (lines.existsBridge(position, h)) {
            return moveLeft();
        }

        if (position != lines.getWidth() - 1 && lines.existsBridge(position + 1, h)) {
            return moveRight();
        }

        return this;
    }

    private Position moveLeft() {
        return new Position(position - 1);
    }

    private Position moveRight() {
        return new Position(position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
