package ladder.domain;

import java.util.Random;

public class LadderDirectionNext {

    private static Random random = new Random();
    private static int MOVE_DISTANCE = 1;

    private LadderDirectionNext(){

    }

    public static LadderDirection makeDirectionFirst() {
        LadderDirection direction = new LadderDirection(false, random.nextBoolean());
        return direction;
    }

    public static LadderDirection makeDirectionBody(LadderDirection ladderDirection) {
        return moveNext(ladderDirection);
    }

    public static LadderDirection makeDirectionLast(LadderDirection ladderDirection) {
        LadderDirection direction = new LadderDirection(ladderDirection.isRight(), false);

        return direction;
    }

    private static LadderDirection moveNext(LadderDirection ladderDirection) {
        LadderDirection returnDirection;

        if (ladderDirection.isRight()) {
            returnDirection = new LadderDirection(true, false);
            return returnDirection;
        }

        return moveRight();
    }

    private static LadderDirection moveRight() {
        return new LadderDirection(false, random.nextBoolean());
    }
}
