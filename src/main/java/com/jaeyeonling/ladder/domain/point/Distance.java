package com.jaeyeonling.ladder.domain.point;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Distance {

    private static final Map<Integer, Distance> CACHE = new HashMap<>();

    static final Distance STOP = valueOf(0);

    private final Integer value;

    private Distance(final Integer value) {
        this.value = value;
    }

    public static Distance valueOf(final Integer value) {
        return CACHE.computeIfAbsent(value, Distance::new);
    }

    Position move(final Distance movingDistance) {
        final Distance addedDistance = add(movingDistance);

        return Position.valueOf(addedDistance.value);
    }

    private Distance add(final Distance other) {
        return valueOf(this.value + other.value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Distance)) {
            return false;
        }

        final Distance that = (Distance) o;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
