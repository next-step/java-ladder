package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.exception.ShorterThanMinPositiveException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Positive {

    private static final Map<Integer, Positive> POOL = new HashMap<>();

    public static final int MIN = 1;

    private final int positive;

    private Positive(final int positive) {
        this.positive = positive;
    }

    public static Positive valueOf(final int positive) {
        if (positive < MIN) {
            throw new ShorterThanMinPositiveException(positive);
        }

        return POOL.computeIfAbsent(positive, Positive::new);
    }

    public IntStream rangeClosed() {
        return IntStream.rangeClosed(MIN, positive);
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
        return positive == that.positive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positive);
    }
}
