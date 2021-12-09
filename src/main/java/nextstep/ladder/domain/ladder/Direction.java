package nextstep.ladder.domain.ladder;

import static nextstep.ladder.domain.ladder.LadderPointGenerator.generatePoint;

public enum Direction {
    LEFT("┤"),
    RIGHT("├"),
    NONE("┃");

    private final String shape;

    Direction(String shape) {
        this.shape = shape;
    }

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

    public String getShape() {
        return shape;
    }
}
