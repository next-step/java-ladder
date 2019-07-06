package nextstep.step4.ladder.domain;

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
    private static final String CREATE_LIST_SIZE_EXCEPTION_MESSAGE = "사다리가 비어있습니다.";

    private List<LadderLine> ladder;

    public Ladder(List<LadderLine> ladder) {
        if (ladder.isEmpty() || ladder == null) {
            throw new IllegalArgumentException(CREATE_LIST_SIZE_EXCEPTION_MESSAGE);
        }
        this.ladder = ladder;
    }

    public int execute(int startIndex) {
        int endIndex = startIndex;
        for (LadderLine ladderLine : ladder) {
            endIndex = ladderLine.moveLine(endIndex);
        }
        return endIndex;
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }
}
