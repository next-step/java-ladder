package nextstep.ladder.controller;

import nextstep.ladder.domain.LineSelector;

import java.util.Random;

public class RandomLineSelector implements LineSelector {
    private Random random;

    public RandomLineSelector() {
        random = new Random();
    }

    @Override public int select(int size) {
        return random.nextInt(size);
    }
}
