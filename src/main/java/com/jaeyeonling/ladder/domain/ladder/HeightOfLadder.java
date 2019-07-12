package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.Positive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class HeightOfLadder {

    private static final Map<Positive, HeightOfLadder> POOL = new HashMap<>();

    private final Positive heightOfLadder;

    private HeightOfLadder(final Positive heightOfLadder) {
        this.heightOfLadder = heightOfLadder;
    }

    public static HeightOfLadder valueOf(final int heightOfLadder) {
        return POOL.computeIfAbsent(Positive.valueOf(heightOfLadder), HeightOfLadder::new);
    }

    IntStream rangeClosed() {
        return heightOfLadder.rangeClosed();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HeightOfLadder)) {
            return false;
        }

        final HeightOfLadder that = (HeightOfLadder) o;
        return Objects.equals(heightOfLadder, that.heightOfLadder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heightOfLadder);
    }
}
