package nextstep.domain;

import nextstep.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_LADDER_LENGTH = 1;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countPerson, LineStrategy lineStrategy) {
        if (height < MINIMUM_LADDER_LENGTH) {
            throw new IllegalArgumentException("사다리의 높이는 " + MINIMUM_LADDER_LENGTH + " 이상의 양수이어야 한다.");
        }

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countPerson, lineStrategy));
        }
    }

    public int search(int idx) {
        for (Line line : lines) {
            idx = line.search(idx);
        }
        return idx;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
