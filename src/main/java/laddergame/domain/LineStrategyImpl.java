package laddergame.domain;

import laddergame.utils.RandomGenerator;

public class LineStrategyImpl implements LineStrategy {

    private static final int TARGET_NUM = 1;

    @Override
    public boolean isMovable() {
        return RandomGenerator.create() == TARGET_NUM;
    }
}
