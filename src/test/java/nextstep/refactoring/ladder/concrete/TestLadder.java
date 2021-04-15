package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Line;

import java.util.Arrays;

public class TestLadder {

    public static Ladder ladder() {
        return new Ladder(Arrays.asList(
            twoConnectedLine(),
            middleConnectedLine(),
            firstConnectedLine(),
            middleConnectedLine(),
            twoConnectedLine()
        ), 4);
    }

    public static Line twoConnectedLine() {
        return LadderLine.of(Point.of(0, Direction.right()),
            Point.of(1, Direction.left()),
            Point.of(2, Direction.right()),
            Point.of(3, Direction.left())
        );
    }

    public static Line middleConnectedLine() {
        return LadderLine.of(Point.of(0, Direction.straight()),
            Point.of(1, Direction.right()),
            Point.of(2, Direction.left()),
            Point.of(3, Direction.straight())
        );
    }

    public static Line firstConnectedLine() {
        return LadderLine.of(Point.of(0, Direction.right()),
            Point.of(1, Direction.left()),
            Point.of(2, Direction.straight()),
            Point.of(3, Direction.straight())
        );
    }

}
