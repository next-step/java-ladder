package ladder.domain;

import java.util.Objects;

public class Move {

    private boolean previous;
    private boolean current;

    public Move(boolean previous, boolean current) {
        this.previous = previous;
        this.current = current;
    }

    public static Move right() {
        return new Move(false, true);
    }

    public static Move stay() {
        return new Move(false, false);
    }

    public static Move left() {
        return new Move(true, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return previous == move.previous &&
                current == move.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(previous, current);
    }

}
