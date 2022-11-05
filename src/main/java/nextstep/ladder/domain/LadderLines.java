package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLines {
    private final List<Line> lines;

    public LadderLines(int countOfUser, int height, LineStrategy lineStrategy) {
        this.lines = new ArrayList<>();
        addLines(countOfUser, height, lineStrategy);
    }

    private void addLines(int countOfUser, int height, LineStrategy lineStrategy) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfUser, lineStrategy));
        }
    }

    Line getLine(int idx) {
        return lines.get(idx);
    }

    int getHeight() {
        return lines.size();
    }

    int getArriveIdx(int idx) {
        for (Line line : lines) {
            idx = moveLine(line, idx);
        }
        return idx;
    }

    private int moveLine(Line line, int idx) {
        if (line.existPoint(idx)) {
            return idx + 1;
        }

        if (idx > 0 && line.existPoint(idx - 1)) {
            return idx - 1;
        }
        return idx;
    }
}
