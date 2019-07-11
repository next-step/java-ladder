package ladder.domain.ladderline;

import ladder.common.PositiveNumber;
import ladder.common.RandomStrategy;

import java.util.List;

public class LadderProxy {

    public static LadderLines createLadderLines(List<LadderLine> ladderLine) {
        return LadderLines.of(ladderLine);
    }

    public static LadderLine createLadderLine(RandomStrategy randomStrategy, PositiveNumber countOfUsers) {
        return LadderLine.of(randomStrategy, countOfUsers);
    }

    public static int move(LadderLines ladderLines, int startIndex) {
        return ladderLines.move(Index.of(startIndex)).get();
    }
}
