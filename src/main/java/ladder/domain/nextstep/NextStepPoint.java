package ladder.domain.nextstep;

import ladder.domain.engine.Point;

public enum NextStepPoint implements Point {
    LEFT(-1),
    DOWN(0),
    RIGHT(1);

    private final int move;

    NextStepPoint(int move) {
        this.move = move;
    }

    public static NextStepPoint randomPoint() {
        if(RandomGenerator.randomInt() == 1){
            return RIGHT;
        }
        return DOWN;
    }

    public static NextStepPoint next(NextStepPoint point) {
        if (point.move == 1) {
            return LEFT;
        }
        return randomPoint();
    }

    public static NextStepPoint last(NextStepPoint point) {
        if (point.move == 1) {
            return LEFT;
        }
        return DOWN;
    }

    public int move(){
        return move;
    }
}