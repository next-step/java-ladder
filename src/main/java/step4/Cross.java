package step4;

import java.util.Objects;

public class Cross {

    private final boolean before;
    private final boolean current;

    public Cross(boolean before, boolean current) {
        if (before && current) {
            throw new IllegalArgumentException("사다리 타기 게임에서 양쪽 모두 가지가 존재할 수는 없습니다.");
        }
        this.before = before;
        this.current = current;
    }

    public static Cross of(boolean before, boolean current) {
        return new Cross(before, current);
    }

    public static Direction first(boolean current) {
        if (current) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cross cross = (Cross) o;
        return before == cross.before && current == cross.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(before, current);
    }
}
