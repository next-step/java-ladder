package ladder.domain.ladder;

import java.util.List;

import static ladder.domain.ladder.LadderConnection.*;

public class LadderSampleData {
    // |-| | |
    public static final LadderLine lineA = new LadderLine(
            List.of(
                    new LadderColumn(0, RIGHT),
                    new LadderColumn(1, LEFT),
                    new LadderColumn(2, NONE),
                    new LadderColumn(3, NONE)
            )
    );

    // | |-| |
    public static final LadderLine lineB = new LadderLine(
            List.of(
                    new LadderColumn(0, NONE),
                    new LadderColumn(1, RIGHT),
                    new LadderColumn(2, LEFT),
                    new LadderColumn(3, NONE)
            )
    );

    // | | |-|
    public static final LadderLine lineC = new LadderLine(
            List.of(
                    new LadderColumn(0, NONE),
                    new LadderColumn(1, NONE),
                    new LadderColumn(2, RIGHT),
                    new LadderColumn(3, LEFT)
            )
    );


    public static final Ladder ladder = new Ladder(List.of(
            lineA,
            lineB,
            lineC
    ));
}
