package step4.domain.ladder;

import java.util.Random;
import java.util.function.Function;

public enum LadderPoint {
    LEFT(x -> x - 1),
    RIGHT(x -> x + 1),
    NONE(x -> x);

    private final Function<Integer, Integer> move;

    LadderPoint(Function<Integer, Integer> move) {
        this.move = move;
    }

    public static LadderPoint makeRandomPoint(LadderPoint ladderPoint) {
        if (ladderPoint == RIGHT) return LadderPoint.LEFT;

        return values()[makeRandomInt()];
    }

    private static int makeRandomInt() {
        return new Random().nextInt(2) + 1;
    }

    public int move(int x) {
        return move.apply(x);
    }
}
