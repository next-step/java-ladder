package nextstep.step2.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 04:19
 */
public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 3;
    private static final int MIN_LADDER_LINE = 2;
    private static final String EXCEPTION_MESSAGE_FORMANT = "사다리의 높이는 3, 길이는 2이상만 가능합니다. 높이:[%d] 길이:[%d]";

    private List<LadderLine> ladder;

    public Ladder(int line, int row) {
        if (row < MIN_LADDER_HEIGHT || line < MIN_LADDER_LINE) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FORMANT, row, line));
        }

        this.ladder = createLadder(line, row);
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }

    private List<LadderLine> createLadder(int line, int row) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ladderLines.add(new LadderLine(line));
        }
        return ladderLines;
    }
}
