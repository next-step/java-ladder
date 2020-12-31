package ladder.domain;


import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 1;

    private List<LadderLine> ladderLines = new ArrayList<>();

    public Ladder(final int ladderHeight, final int countOfPerson) {
        checkValue(ladderHeight, countOfPerson);
        initLines(ladderHeight, countOfPerson);
    }

    private void initLines(final int ladderHeight, final int countOfPerson) {
        LadderLine line;
        List<LadderLine> lines= new ArrayList<>();
        lines.add(new LadderLine(countOfPerson));

        for (int i = 1; i < ladderHeight; i++) {
            line = LadderLine.makeNextLine(lines.get(i - 1));
            lines.add(line);
        }

        this.ladderLines = lines;
    }

    private void checkValue(final int ladderHeight, final int countOfPerson) {
        checkLadderHeight(ladderHeight);
        checkCountOfPerson(countOfPerson);
    }

    private void checkCountOfPerson(int countOfPerson) {
        if (countOfPerson < MIN_LADDER_HEIGHT) {
            throw new RuntimeException(ErrorMessage.getCheckInputLadderHeight());
        }
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new RuntimeException(ErrorMessage.getCheckInputLadderHeight());
        }
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "ladderLines=" + ladderLines +
                '}';
    }
}
