package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.exception.ShorterThanMinPositiveException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Positive {

    private static final Map<Integer, Positive> CACHE = new HashMap<>();

    public static final int MIN = 1;

    private final int value;

    private Positive(final int value) {
        this.value = value;
    }

    public static Positive valueOf(final int value) {
        if (value < MIN) {
            throw new ShorterThanMinPositiveException(value);
        }

        return CACHE.computeIfAbsent(value, Positive::new);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Positive)) {
            return false;
        }

        final Positive that = (Positive) o;
        return this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
