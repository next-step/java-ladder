package ladder.domain;


import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 1;

    private List<LadderLine> ladderLines = new ArrayList<>();

    public Ladder(final int ladderHeight, final int countOfPerson) {
        checkValue(ladderHeight, countOfPerson);
        initAddLine(ladderHeight, countOfPerson);
    }

    private void initAddLine(final int ladderHeight, final int countOfPerson) {
        initFirstAddLine(countOfPerson);
        initOutherAddLine(ladderHeight);
    }

    private void initFirstAddLine(final int countOfPerson) {
        LadderLine line = new LadderLine(countOfPerson);

        this.ladderLines.add(line);
    }

    private void initOutherAddLine(final int ladderHeight) {
        LadderLine line;

        for (int i = 1; i < ladderHeight; i++) {
            line = new LadderLine(ladderLines.get(i - 1));
            ladderLines.add(line);
        }
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
}
