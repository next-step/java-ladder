package ladder.domain;


import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<LadderPoints> LadderLine = new ArrayList<>();

    public LadderLine(final int ladderHeight, final int countOfPerson) {
        checkValue(ladderHeight, countOfPerson);
        addLadderLine(ladderHeight, countOfPerson);
    }

    private void addLadderLine(final int ladderHeight, final int countOfPerson) {
        LadderPoints points;

        for (int i = 0; i < ladderHeight; i++) {
            points = new LadderPoints(countOfPerson);
            this.LadderLine.add(points);
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

    public List<LadderPoints> getLadderLine() {
        return LadderLine;
    }
}