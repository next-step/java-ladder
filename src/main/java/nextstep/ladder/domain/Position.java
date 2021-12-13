package nextstep.ladder.domain;

import static nextstep.ladder.utils.IntegerUtils.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Position {

    private static final Map<Integer, Position> cache = new HashMap<>();
    private static final int UNIT = 1;

    private final int position;

    static {
        IntStream.range(0, 100).forEach(position -> cache.put(position, new Position(position)));
    }

    private Position(int position) {
        this.position = getNumberIfNotNegative(position);
    }

    public static Position of(int position) {
        return cache.getOrDefault(position, new Position(position));
    }

    public Position move(Line line) {
        if (hasLeft(line)) {
            return Position.of(position - UNIT);
        }

        if (hasRight(line)) {
            return Position.of(position + UNIT);
        }

        return this;
    }

    public boolean hasLeft(Line line) {
        if (position - UNIT < 0) {
            return false;
        }

        if (position > line.size()) {
            return false;
        }

        return line.get(position - UNIT);
    }

    public boolean hasRight(Line line) {
        if (position < 0) {
            return false;
        }

        if (position > line.size() - UNIT) {
            return false;
        }

        return line.get(position);
    }


    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return getPosition() == position1.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
