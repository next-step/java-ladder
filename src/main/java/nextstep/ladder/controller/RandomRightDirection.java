package nextstep.ladder.controller;

import nextstep.ladder.domain.RightDirection;

import java.util.Random;

public class RandomRightDirection implements RightDirection {
    private Random random;

    public RandomRightDirection() {
        this.random = new Random();
    }

    @Override public boolean isAbleToRight() {
        return random.nextBoolean();
    }
}
