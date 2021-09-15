package step2.domain;

public class Position {
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    private static final String DOWN = "down";

    private final int widthIndex;
    private final String nextStatus;

    public Position (int widthIndex) {
        this(widthIndex, DOWN);
    }

    public Position(int widthIndex, String nextStatus) {
        this.widthIndex = widthIndex;
        this.nextStatus = nextStatus;
    }

    public Position moveLeft() {
        return new Position(this.widthIndex - 1, LEFT);
    }

    public Position moveRight() {
        return new Position(this.widthIndex + 1, RIGHT);
    }

    public Position moveDown() {
        return new Position(this.widthIndex, DOWN);
    }

    public boolean canMoveToLeft() {
        return this.widthIndex > 0;
    }

    public boolean canMoveToRight(int lineSize) {
        return this.widthIndex + 1 < lineSize;
    }

    public int getWidthIndex() {
        return this.widthIndex;
    }

    public int nextPosition() {
        return this.widthIndex + 1;
    }

    public int currentPosition() {
        return this.widthIndex;
    }

    public boolean isRight() {
        return this.nextStatus.equals(RIGHT);
    }

    public boolean isLeft() {
        return this.nextStatus.equals(LEFT);
    }

    public boolean isDown() {
        return this.nextStatus.equals(DOWN);
    }
}
