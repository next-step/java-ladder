package ladder.domain;

import ladder.view.exception.InvalidLadderHeightException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int LINE_COUNT_MIN = 1;

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder getInstance(int height, int countOfPerson) {
        if (height < LINE_COUNT_MIN) {
            throw new InvalidLadderHeightException();
        }

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.init(countOfPerson));
        }

        return new Ladder(lines);
    }

    public LadderMatchResult play() {
        LadderMatchResult ladderMatchResult = new LadderMatchResult();

        int lineSize = lines.size();
        for (int i = 0; i < lineSize; i++) {
            ladderMatchResult.put(i, getLastIndex(i));
        }

        return ladderMatchResult;
    }

    private int getLastIndex(int startIndex) {
        int index = startIndex;
        for (Line line : lines) {
            index = line.move(index);
        }

        return index;
    }

    public boolean isHeightSame(int height) {
        return lines.size() == height;
    }
}
