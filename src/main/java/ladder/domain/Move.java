package ladder.domain;

import java.util.Objects;

public class Move {

    private boolean previous;
    private boolean current;

    public Move(boolean previous, boolean current) {
        this.previous = previous;
        this.current = current;
    }

    public int findLocation() {
        if (!previous && current) {
            return 1;
        } else if (!previous && !current) {
            return 0;
        } else {
            return -1;
        }
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
