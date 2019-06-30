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
    private List<LadderLine> ladder = new ArrayList<>();

    public Ladder(int line, int row) {
        // line 유효성 체크는 Custom에서 해주기 때문에 별도로 처리 X
        if (row < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 3이상만 가능합니다.");
        }

        for (int i = 0; i < row; i++) {
            ladder.add(new LadderLine(line));
        }
    }

    public List<LadderLine> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public Stream<LadderLine> stream() {
        return ladder.stream();
    }
}
