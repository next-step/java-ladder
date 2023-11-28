package me.namuhuchutong.ladder.domain.implement.discriminator;

import me.namuhuchutong.ladder.domain.engine.ScaffoldGenerator;

import java.util.Random;

public class ScaffoldRandomGenerator implements ScaffoldGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public boolean canGenerate() {
        return RANDOM.nextBoolean();
    }
}
