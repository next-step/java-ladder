package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

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
    private List<LadderLine> ladder;

    public Ladder(int line, int row) {
        // line 유효성 체크는 Custom에서 해주기 때문에 별도로 처리 X
        if (row < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 3이상만 가능합니다.");
        }

        List<LadderLine> ladderLines = new ArrayList<>();
        this.ladder = ladderLines;
    }
}
