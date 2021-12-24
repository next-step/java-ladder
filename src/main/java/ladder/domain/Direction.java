package ladder.domain;

import ladder.strategy.GeneratorStrategy;

public enum Direction {
    LEFT,
    RIGHT,
    STAY;

    Direction() {

    }

    private static Direction canMoveRight(GeneratorStrategy generatorStrategy) {
        if (generatorStrategy.canMove()) {
            return Direction.RIGHT;
        }
        return Direction.STAY;
    }

    public static Direction first(GeneratorStrategy generatorStrategy) {
        return canMoveRight(generatorStrategy);
    }

    public Direction next(final GeneratorStrategy generatorStrategy) {
        if (this == RIGHT) {
            return Direction.LEFT;
        }
        return canMoveRight(generatorStrategy);
    }

    public Direction last() {
        if(this ==  RIGHT) {
            return Direction.LEFT;
        }
        return Direction.STAY;
    }
}
