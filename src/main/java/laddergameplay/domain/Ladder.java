package laddergameplay.domain;

import laddergameplay.exception.CustomException;
import laddergameplay.strategy.LineStrategy;

import java.util.*;

public class Ladder {

    public static final int FIRST_PILLAR_OF_LADDER = 0;

    private final List<Line> ladder = new ArrayList<>();
    private final int lastPillarOfLadder;

    public Ladder(People people, int heightOfLadder, LineStrategy lineStrategy) {
        this.lastPillarOfLadder = people.subtractNumberFromSize(1);

        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(lastPillarOfLadder, lineStrategy));
        }
    }

    public List<Integer> result(){
        List<Integer> resultList = new ArrayList<>();

        for (int startPosition = FIRST_PILLAR_OF_LADDER; startPosition <= lastPillarOfLadder; startPosition++) {
            int resultPosition = playGame(startPosition);
            resultList.add(resultPosition);
        }
        return resultList;
    }

    private int playGame(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : ladder) {
            currentPosition = movePosition(currentPosition, line);
        }

        return currentPosition;
    }

    private void validateOutOfRange(int currentPosition) {
        if(!(FIRST_PILLAR_OF_LADDER <= currentPosition && currentPosition <= lastPillarOfLadder)) {
            throw new CustomException("참여자가 사다리를 벗어났습니다.");
        }
    }

    private int movePosition(int currentPosition, Line line) {
        validateOutOfRange(currentPosition);
        return movePositionWhenCurrentIsZero(currentPosition, line);
    }

    private int movePositionWhenCurrentIsZero(int currentPosition, Line line) {
        if (currentPosition == FIRST_PILLAR_OF_LADDER) {
            return movePositionCheckRight(currentPosition, line);
        }
        return movePositionWhenCurrentIsEnd(currentPosition, line);
    }

    private int movePositionWhenCurrentIsEnd(int currentPosition, Line line) {
        if (currentPosition == lastPillarOfLadder) {
            return movePositionCheckLeft(currentPosition, line);
        }

        return movePositionWhenCurrentInMiddle(currentPosition, line);
    }

    private int movePositionWhenCurrentInMiddle(int currentPosition, Line line) {
        if (line.get(rightPointOf(currentPosition))) {
            return moveRight(currentPosition);
        }
        return movePositionCheckLeft(currentPosition, line);
    }

    private int movePositionCheckRight(int currentPosition, Line line) {
        if (line.get(rightPointOf(currentPosition))) {
            return moveRight(currentPosition);
        }
        return currentPosition;
    }

    private int movePositionCheckLeft(int currentPosition, Line line) {
        if (line.get(leftPointOf(currentPosition))) {
            return moveLeft(currentPosition);
        }
        return currentPosition;
    }

    private int moveRight(int currentPosition) {
        return currentPosition + 1;
    }

    private int moveLeft(int currentPosition) {
        return currentPosition - 1;
    }

    private int rightPointOf(int currentPosition) {
        return currentPosition;
    }

    private int leftPointOf(int currentPosition) {
        return currentPosition - 1;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
