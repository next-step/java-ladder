package com.jaeyeonling.ladder.domain.point;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position valueOf(final int position) {
        return CACHE.computeIfAbsent(position, Position::new);
    }

    public Position move(final Distance movingDistance) {
        final Distance distance = Distance.valueOf(this.value);
        return distance.move(movingDistance);
    }

    int getValue() {
        return this.value;
    }

    Position next() {
        return valueOf(this.value + Direction.DEFAULT_MOVING_DISTANCE_VALUE);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position)) {
            return false;
        }

        final Position that = (Position) o;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
