package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 2;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int participantCount, int ladderHeight) {
        if (isLessThanTwo(ladderHeight)) {
            throw new IllegalArgumentException("사다리의 높이는 2 이상입니다.");
        }

        int ladderLength = getLadderLength(participantCount);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(ladderLength));
        }

        return new Ladder(lines);
    }

    private static int getLadderLength(int participantCount) {
        return participantCount * 2 - 1;
    }

    private static boolean isLessThanTwo(int ladderHeight) {
        return ladderHeight < MIN_HEIGHT;
    }

    public List<Line> getLines() {
        return lines;
    }
}
