package me.namuhuchutong.ladder.domain.implement.discriminator;

import me.namuhuchutong.ladder.domain.engine.ScaffoldDiscriminator;

import java.util.Random;

public class ScaffoldRandomDiscriminator implements ScaffoldDiscriminator {

    private static final Random RANDOM = new Random();

    private boolean createdBefore;

    public ScaffoldRandomDiscriminator() {
        this.createdBefore = false;
    }

    @Override
    public boolean isNotCreatedBefore() {
        if (RANDOM.nextBoolean() && !createdBefore) {
            createdBefore = true;
            return true;
        }
        createdBefore = false;
        return false;
    }
}
