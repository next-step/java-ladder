package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
        RandomLineCondition lineCondition = new RandomLineCondition();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson, lineCondition));
        }
    }

    public Ladder(int countOfPerson, List<LineCondition> condition) {
        if (condition.size() < 1) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
        for (LineCondition lineCondition : condition) {
            lines.add(new Line(countOfPerson, lineCondition));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
