package step02.ladder;

import step02.utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int ZERO = 0;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int xLineCount, int yLineCount) throws IllegalAccessException {
        Validation.checkZeroLine(yLineCount);
        for (int i = 0; i < yLineCount; i++) {
            lines.add(new Line(xLineCount));
        }
    }

    public int getYLineCount() {
        if (lines.size() > ZERO) {
            return lines.get(ZERO).getLadderHeight();
        }
        return ZERO;
    }

    public int getXLineCount() {
        return lines.size();
    }

    public List<Line> getLadderLine() {
        return lines;
    }

    public boolean isHasLine(int xPoint, int yPoint) {
        return lines.get(yPoint).isHasLine(xPoint);
    }
}

