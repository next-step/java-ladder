package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int FIRST = 1;
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PERSON = 2;

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
        if (height < MIN_HEIGHT) {
            throw new InvalidHeightException();
        }
        if (countOfPerson < MIN_PERSON) {
            throw new NotEnoughCountOfPersonException();
        }
    }

    private List<LadderLine> buildLadderLines(int height) {
        List<LadderLine> allLines = new ArrayList<>();
        allLines.add(generateFirstLine(height));
        int normalLineCount = Math.subtractExact(countOfPerson, FIRST);

        for (int i = FIRST; i < normalLineCount; i++) {
            int beforeIndex = Math.subtractExact(i, FIRST);
            allLines.add(generateBodyLine(height, allLines.get(beforeIndex)));
        }
        allLines.add(generateLastLine(height));
        return allLines;
    }

    private LadderLine generateFirstLine(int height) {
        return new LadderLine(LinesGenerator.first(height));
    }

    private LadderLine generateLastLine(int height) {
        return new LadderLine(LinesGenerator.last(height));
    }

    private LadderLine generateBodyLine(int height, LadderLine ladderLine) {
        return new LadderLine(LinesGenerator.normal(height, ladderLine));
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "countOfPerson=" + countOfPerson +
                ", ladder=" + ladder +
                '}';
    }
}
