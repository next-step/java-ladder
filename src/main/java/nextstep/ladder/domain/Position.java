package nextstep.ladder.domain;

public class Position {

    private int x;
    private int y;
    private int initialX;

    public Position() {
        this(0, 0);
    }

    public Position(final int x, final int y) {
        if (x < 0) {
            throw new IllegalArgumentException("더이상 왼쪽으로 이동하지 않습니다.");
        }
        this.x = x;
        this.y = y;
        this.initialX = x;
    }

    public Position(final int x, final int y, final int initialX) {
        if (x < 0) {
            throw new IllegalArgumentException("더이상 왼쪽으로 이동하지 않습니다.");
        }
        this.x = x;
        this.y = y;
        this.initialX = x;
    }

    public Position move(Direction direction) {
        if (direction.isRight()) {
            return new Position(getMoveRightX(), getMoveY());
        }

        if (direction.isLeft()) {
            return new Position(getMoveLeftX(), getMoveY());
        }

        return new Position(getPassX(), getMoveY());
    }

    private int getMoveLeftX() {
        return --x;
    }

    private int getMoveRightX() {
        return ++x;
    }

    private int getMoveY() {
        return ++y;
    }

    private int getPassX() {
        return x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getInitialX() {
        return initialX;
    }


}
