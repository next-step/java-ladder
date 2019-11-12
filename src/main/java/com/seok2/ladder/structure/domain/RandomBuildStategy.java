package com.seok2.ladder.structure.domain;

import java.util.Random;

public class RandomBuildStategy implements BuildStrategy {

    private final Random random = new Random();

    @Override
    public Line apply(Line previous) {
        return random.nextBoolean() ? previous : null;
    }
}
