package com.jaeyeonling.ladder.domain.ladder;

import com.jaeyeonling.ladder.domain.Positive;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HeightOfLadder {

    private static final Map<Positive, HeightOfLadder> CACHE = new HashMap<>();

    private final Positive heightOfLadder;

    private HeightOfLadder(final Positive heightOfLadder) {
        this.heightOfLadder = heightOfLadder;
    }

    public static HeightOfLadder of(final int heightOfLadder) {
        return valueOf(Positive.valueOf(heightOfLadder));
    }

    public static HeightOfLadder valueOf(final Positive countOfUsers) {
        return CACHE.computeIfAbsent(countOfUsers, HeightOfLadder::new);
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
        return Objects.equals(this.heightOfLadder, that.heightOfLadder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.heightOfLadder);
    }
}
