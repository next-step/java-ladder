package cc.oakk.ladder.model.line;

import java.util.Objects;

import static cc.oakk.ladder.util.ValidationUtils.throwIfNull;

public class Connection {
    private static final int START = 0;

    private final int index;
    private final Direction direction;

    private Connection(int index, Direction direction) {
        if (index == START && throwIfNull(direction).isLeft()) {
            throw new IllegalArgumentException("시작하는 연결점은 왼쪽으로의 연결이 없어야합니다.");
        }
        this.index = index;
        this.direction = direction;
    }

    public static Connection start(boolean right) {
        return new Connection(START, Direction.of(false, right));
    }

    public Connection next(boolean right) {
        return new Connection(index + 1, direction.next(right));
    }

    public Connection end() {
        return next(false);
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public int move() {
        if (isLeft()) {
            return -1;
        }

        if (isRight()) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return index == that.index &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
