package nextstep.step3.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
    private static final int DECREASE_INDEX = 1;

    private List<Link> ladderLine = new ArrayList<>();

    public LadderLine(int line) {
        if (line < LINE_MIN_INDEX) {
            throw new IllegalArgumentException("사다리 라인이 유효한 개수가 아닙니다.");
        }

        ladderLine.add(Link.of(() -> random()));
        for (int i = 1; i < line; i++) {
            ladderLine.add(addStatusByIndexPosition(i, line));
        }
    }

    public Stream<Link> stream() {
        return ladderLine.stream();
    }

    private Link addStatusByIndexPosition(int index, int line) {
        int size = ladderLine.size();
        int exclusionLastIndex = line - DECREASE_INDEX;

        if (exclusionLastIndex != size) {
            return Link.of(() -> ladderLine.get(index - DECREASE_INDEX).status() ? false : random());
        }
        return Link.of(() -> false);
    }

    private boolean random() {
        return new Random().nextBoolean();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "ladderLine=" + ladderLine +
                '}';
    }
}
