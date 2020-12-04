package ladder.domain;

import ladder.dto.LadderLineDTO;
import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private static final int MIN_LADDER_HEIGHT = 1;
    private LadderLineDTO ladderLineDTO = new LadderLineDTO();

    public LadderLine(final int ladderHeight, final int countOfPerson) {
        checkValue(ladderHeight, countOfPerson);
        addladderLine(ladderHeight, countOfPerson);
    }

    private void addladderLine(final int ladderHeight, final int countOfPerson) {
        List<List<Boolean>> list = new ArrayList<>();
        LadderPoint point;

        for (int i = 0; i < ladderHeight; i++) {
            point = new LadderPoint(countOfPerson);
            list.add(point.getPoints());
        }

        ladderLineDTO.setLadderLine(list);
    }

    public LadderLineDTO getLadderLineDTO() {
        return ladderLineDTO;
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
}