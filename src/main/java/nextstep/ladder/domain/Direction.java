package nextstep.ladder.domain;

import static nextstep.ladder.domain.LadderPointGenerator.generatePoint;

public enum Direction {
    LEFT(),
    RIGHT(),
    NONE();

    public static Direction first(boolean right) {
        return right ? RIGHT : NONE;
    }

    public Direction next() {
        if(this == RIGHT){
            return LEFT;
        }
        return nextNotHaveLeft(generatePoint());
    }

    private Direction nextNotHaveLeft(boolean nextRight){
        return nextRight ? RIGHT : NONE;
    }

    public Direction last(){
        return this == RIGHT ? LEFT : NONE;
    }

}
