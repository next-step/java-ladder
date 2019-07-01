package com.jaeyeonling.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Distance {

    private static final Map<Integer, Distance> CACHE = new HashMap<>();

    public static final Distance STOP = valueOf(0);

    private final Integer value;

    private Distance(final Integer value) {
        this.value = value;
    }

    public static Distance valueOf(final Integer value) {
        return CACHE.computeIfAbsent(value, Distance::new);
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
