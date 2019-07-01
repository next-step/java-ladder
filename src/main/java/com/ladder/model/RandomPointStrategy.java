package com.ladder.model;

import java.util.Random;

public class RandomPointStrategy implements PointStrategy {

    private static final Random random = new Random();

    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}