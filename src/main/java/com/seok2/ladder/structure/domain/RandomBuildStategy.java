package com.seok2.ladder.structure.domain;

import java.util.Random;

public class RandomBuildStategy implements BuildStrategy {

    private final Random random = new Random();

    @Override
    public Pillar apply(Pillar previous) {
        return random.nextBoolean() ? previous : null;
    }
}
