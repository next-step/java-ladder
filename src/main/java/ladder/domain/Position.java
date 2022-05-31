package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Type;
import ladder.exception.NotChangeException;

import java.util.Objects;

public class Position {

    private static final String MESSAGE_NOT_CHANGE_FIXED = "고정된 Position 이여서 변경할 수 없습니다.";

    private final Name name;
    private final Index index;
    private Type type;

    public Position(int maxIndex, int index, String name, Type type) {
        this(new Index(maxIndex, index), new Name(name), type);
    }

    public Position(Index index, Name name, Type type) {
        this.index = index;
        this.name = name;
        this.type = type;
    }

    public void change(Direction direction) {
        if (isFixed()) {
            throw new NotChangeException(MESSAGE_NOT_CHANGE_FIXED);
        }
        index.change(direction);
    }

    public Name name() {
        return name;
    }

    public int nameSize() {
        return name.size();
    }

    public int withoutNameSize(int maxSize) {
        return maxSize - name.size();
    }

    public boolean hasSame(Name name) {
        return this.name.equals(name);
    }

    public boolean hasSame(Index index) {
        return this.index.equals(index);
    }

    public Index index() {
        return index;
    }

    public boolean isFixed() {
        return type.fixed();
    }

    public boolean isUnfixed() {
        return !type.fixed();
    }

    public void fix() {
        type = Type.FIXED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(name, position.name) && Objects.equals(index, position.index) && type == position.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, type);
    }
}
