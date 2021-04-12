package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.concrete.Direction;
import nextstep.refactoring.ladder.concrete.LadderImpl;
import nextstep.refactoring.ladder.concrete.LadderLine;
import nextstep.refactoring.ladder.concrete.LadderPoint;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.Line;

import java.util.Arrays;

public class TestLadder {

    public static Ladder ladder() {
        return new LadderImpl(Arrays.asList(
            twoConnectedLine(),
            middleConnectedLine(),
            firstConnectedLine(),
            middleConnectedLine(),
            twoConnectedLine()
        ));
    }

    public static Line twoConnectedLine() {
        return LadderLine.of(LadderPoint.of(0, Direction.right()),
            LadderPoint.of(1, Direction.left()),
            LadderPoint.of(2, Direction.right()),
            LadderPoint.of(3, Direction.left())
        );
    }

    public static Line middleConnectedLine() {
        return LadderLine.of(LadderPoint.of(0, Direction.straight()),
            LadderPoint.of(1, Direction.right()),
            LadderPoint.of(2, Direction.left()),
            LadderPoint.of(3, Direction.straight())
        );
    }

    public static Line firstConnectedLine() {
        return LadderLine.of(LadderPoint.of(0, Direction.right()),
            LadderPoint.of(1, Direction.left()),
            LadderPoint.of(2, Direction.straight()),
            LadderPoint.of(3, Direction.straight())
        );
    }

}
