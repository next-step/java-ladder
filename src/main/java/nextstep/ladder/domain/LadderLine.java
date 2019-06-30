package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    private static final int BEFOR_INDEX = 1;
    private List<Link> ladderLine = new ArrayList<>();

    public LadderLine(int line) {
        if (line < LINE_MIN_INDEX) {
            throw new IllegalArgumentException("사다리 라인이 유효한 개수가 아닙니다.");
        }

        ladderLine.add(Link.of(generate(() -> random())));
        for (int i = 1; i < line; i++) {
            ladderLine.add(initStatus(i, line));
        }
    }

    private Link initStatus(int index, int line) {
        int size = ladderLine.size();
        if(line != size) {
            return Link.of(generate(() -> ladderLine.get(index - BEFOR_INDEX).status() ? false : random()));
        }
        return Link.of(false);
    }

    public List<Link> getLadderLine() {
        return Collections.unmodifiableList(ladderLine);
    }

    // 함수형 인터페이스로 구현하려 함.
    private boolean generate(RandomGenerator random) {
        return random.generate();
    }

    private boolean random() {
        return new Random().nextBoolean();
    }
}
