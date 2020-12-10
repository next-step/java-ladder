package ladder.domain;


import ladder.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<LadderLine> ladderLine = new ArrayList<>();

    public Ladder(final int ladderHeight, final int countOfPerson) {
        checkValue(ladderHeight, countOfPerson);
        initAddLine(ladderHeight, countOfPerson);
    }

    private void initAddLine(final int ladderHeight, final int countOfPerson) {
        initFirstAddLine(countOfPerson);
        initOutherAddLine(countOfPerson, ladderHeight);
    }

    private void initFirstAddLine(final int countOfPerson) {
        LadderLine line = new LadderLine(countOfPerson);
        LadderMove ladderMove = new LadderMove(line.getPositionList(), chageDataType(line.getPoints()));

        this.ladderLine.add(new LadderLine(line.getPoints(), ladderMove.getPositionList()));
    }

    private void initOutherAddLine(final int countOfPerson, final int ladderHeight) {
        LadderMove ladderMove;
        LadderLine line;

        for (int i = 1; i < ladderHeight; i++) {
            line = new LadderLine((new LadderLine(countOfPerson).getPoints())
                    , deepCopyPositionList(ladderLine.get(ladderLine.size() - 1).getPositionList()));
            ladderMove = new LadderMove(line.getPositionList(), chageDataType(line.getPoints()));

            this.ladderLine.add(new LadderLine(line.getPoints(), ladderMove.getPositionList()));
        }
    }

    private List<Boolean> chageDataType(List<LadderPoint> beforeList) {
        List<Boolean> afterList = new ArrayList<>();

        for (LadderPoint point : beforeList) {
            afterList.add(point.isLadderPoint());
        }

        return afterList;
    }

    private List<Integer> deepCopyPositionList(List<Integer> positionList) {
        List<Integer> returnList = new ArrayList<>();

        for (Integer position : positionList) {
            returnList.add(position);
        }

        return returnList;
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

    public List<LadderLine> getLadderLine() {
        return ladderLine;
    }
}