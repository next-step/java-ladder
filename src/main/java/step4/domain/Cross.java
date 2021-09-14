package step4.domain;

import static step4.domain.LadderPointGenerator.*;

import java.util.Objects;
import step4.exceptions.BothTrueException;

public class Cross {

    private final boolean before;
    private final boolean current;

    public Cross(boolean before, boolean current) {
        if (before && current) {
            throw new BothTrueException();
        }
        this.before = before;
        this.current = current;
    }

    public static Cross of(boolean before, boolean current) {
        return new Cross(before, current);
    }

    public Direction move() {
        if (this.before) {
            return Direction.LEFT;
        }
        if (this.current) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    public static Cross first(boolean current) {
        if (current) {
            return new Cross(false, true);
        }
        return new Cross(false, false);
    }

    public Cross last() {
        return new Cross(this.current, false);
    }

    public static Cross next(boolean before, boolean current) {
        if (before) {
            return new Cross(true, false);
        }
        if (current) {
            return new Cross(false, true);
        }
        return new Cross(false, false);
    }

    public Cross next(boolean current) {
        return new Cross(this.current, current);
    }

    public Cross next() {
        if (this.current) {
            return new Cross(this.current, false);
        }
        return new Cross(this.current, generatePoint());
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
