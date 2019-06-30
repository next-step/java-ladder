package nextstep.ladder.domain;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladderLine
 * create date  : 2019-06-29 03:27
 */
public class LadderLine {
    private static final int LINE_MIN_INDEX = 0;
    private List<Link> ladderLine;

    public LadderLine(List<Link> ladderLine, int line) {
        if (line < LINE_MIN_INDEX) {
            throw new IllegalArgumentException("사다리 라인이 유효한 개수가 아닙니다.");
        }
        this.ladderLine = ladderLine;
    }
}
