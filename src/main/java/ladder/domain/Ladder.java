package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int FIRST = 1;

    private final int countOfPerson;
    private final List<LadderLine> ladder;

    public Ladder(int height, int countOfPerson) {
        validate(height, countOfPerson);
        this.countOfPerson = countOfPerson;
        this.ladder = buildLadderLines(height);
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }

    private void validate(int height, int countOfPerson) {
        if (height < 1) {
            throw new InvalidHeightException();
        }
        if (countOfPerson < 2) {
            throw new NotEnoughCountOfPersonException();
        }
    }

    private List<LadderLine> buildLadderLines(int height) {
        List<LadderLine> allLines = new ArrayList<>();
        allLines.add(firstLine(height));
        int normalLineCount = Math.subtractExact(countOfPerson, FIRST);
        for (int i = FIRST; i < normalLineCount; i++) {
            int beforeIndex = Math.subtractExact(i, FIRST);
            allLines.add(normalLine(height, allLines.get(beforeIndex)));
        }
        allLines.add(lastLine(height));
        return allLines;
    }

    private LadderLine firstLine(int height) {
        return new LadderLine(LineGenerator.first(height));
    }

    private LadderLine lastLine(int height) {
        return new LadderLine(LineGenerator.last(height));
    }

    private LadderLine normalLine(int height, LadderLine ladderLine) {
        return new LadderLine(LineGenerator.normal(height, ladderLine));
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "countOfPerson=" + countOfPerson +
                ", ladder=" + ladder +
                '}';
    }
}
