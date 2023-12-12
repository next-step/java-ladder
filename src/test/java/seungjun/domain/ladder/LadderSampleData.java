package seungjun.domain.ladder;

import seungjun.ladder.SeungjunLadderBody;
import seungjun.ladder.SeungjunLadderColumn;
import seungjun.ladder.SeungjunLadderLine;

import java.util.List;

import static ladder.LadderConnection.*;

public class LadderSampleData {
    // |-| | |
    public static final SeungjunLadderLine lineA = new SeungjunLadderLine(
            List.of(
                    new SeungjunLadderColumn(0, RIGHT),
                    new SeungjunLadderColumn(1, LEFT),
                    new SeungjunLadderColumn(2, NONE),
                    new SeungjunLadderColumn(3, NONE)
            )
    );

    // | |-| |
    public static final SeungjunLadderLine lineB = new SeungjunLadderLine(
            List.of(
                    new SeungjunLadderColumn(0, NONE),
                    new SeungjunLadderColumn(1, RIGHT),
                    new SeungjunLadderColumn(2, LEFT),
                    new SeungjunLadderColumn(3, NONE)
            )
    );

    // | | |-|
    public static final SeungjunLadderLine lineC = new SeungjunLadderLine(
            List.of(
                    new SeungjunLadderColumn(0, NONE),
                    new SeungjunLadderColumn(1, NONE),
                    new SeungjunLadderColumn(2, RIGHT),
                    new SeungjunLadderColumn(3, LEFT)
            )
    );


    public static final SeungjunLadderBody ladder = new SeungjunLadderBody(List.of(
            lineA,
            lineB,
            lineC
    ));
}
