package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Type;
import ladder.exception.NotChangeException;

import java.util.Objects;

public class Position {

    private static final String MESSAGE_NOT_CHANGE_FIXED = "고정된 Position 이여서 변경할 수 없습니다.";

    private final Index index;
    private Type type;

    public Position(int maxValue, int value, Type type) {
        this.index = new Index(maxValue, value);
        this.type = type;
    }

    public void change(Direction direction) {
        if (fixed()) {
            throw new NotChangeException(MESSAGE_NOT_CHANGE_FIXED);
        }
        index.change(direction);
    }

    public Index index() {
        return index;
    }

    public boolean fixed() {
        return type.fixed();
    }

    public void fix() {
        type = Type.FIXED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(index, position.index) && type == position.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, type);
    }
}
