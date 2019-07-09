package com.jaeyeonling.ladder2.domain;

import com.jaeyeonling.ladder2.exception.ShorterThanMinPositionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Index {

    public static final int INCREMENT_VALUE = 1;
    private static final Map<Integer, Index> POOL = new HashMap<>();
    public static final int MIN = 0;

    private final int index;

    private Index(final int index) {
        this.index = index;
    }

    public static Index valueOf(final int position) {
        if (position < MIN) {
            throw new ShorterThanMinPositionException(position);
        }

        return POOL.computeIfAbsent(position, Index::new);
    }

    public Index increment() {
        return valueOf(index + INCREMENT_VALUE);
    }

    public Index decrement() {
        return valueOf(index - INCREMENT_VALUE);
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Index)) {
            return false;
        }

        final Index that = (Index) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
