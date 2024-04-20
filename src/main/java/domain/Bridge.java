package domain;

public class Bridge {

    private final boolean left;
    private final boolean current;

    private Bridge(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Bridge firstOf(boolean current) {
        return new Bridge(false, current);
    }

    public Bridge next(boolean current) {
        if (this.current && current) {
            throw new IllegalArgumentException("다리를 연속해서 놓을 수 없습니다.");
        }
        return new Bridge(this.current, current);
    }

    public static Bridge nextOf(Bridge prev, boolean current) {
        if (prev.current && current) {
            throw new IllegalArgumentException("다리를 연속해서 놓을 수 없습니다.");
        }
        return new Bridge(prev.current, current);
    }

    public Direction move() {
        if (left) {
            return Direction.LEFT;
        }
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public boolean hasRightBridge() {
        return this.current;
    }

    public boolean isMoveDirection(Direction direction) {
        return this.move() == direction;
    }
}
