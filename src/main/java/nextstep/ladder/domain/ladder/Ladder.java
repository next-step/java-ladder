package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines = new ArrayList<>();
    private final int LEFT = 0;
    private final int RIGHT = 1;

    public Ladder(Line line1, Line line2) {
        lines.add(line1);
        lines.add(line2);
        validate(lines);
    }

    private void validate(List<Line> lines) {
        if(!lines.get(LEFT).isValidateNextLine(lines.get(RIGHT))) {
            throw new RuntimeException("사다리의 가로가 옳바르지 않습니다.");
        }
    }
    public List<Boolean> getPoints() {
        return lines.get(LEFT).getPoints();
    }
}
