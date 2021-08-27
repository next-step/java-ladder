package laddergameplay.domain;

import laddergame.exception.CustomException;
import laddergameplay.strategy.LineStrategy;

import java.util.*;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();
    private final int widthOfLadder;

    public Ladder(People people, int heightOfLadder, LineStrategy lineStrategy) {
        this.widthOfLadder = widthOfLadderOf(people);

        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(widthOfLadder, lineStrategy));
        }
    }

    private int widthOfLadderOf(People people) {
        return people.numberOf() - 1;
    }

    public List<Integer> result(){
        List<Integer> resultList = new ArrayList<>();

        for (int startPosition = 0; startPosition <= widthOfLadder; startPosition++) {
            int resultPosition = playGame(startPosition);
            resultList.add(resultPosition);
        }
        return resultList;
    }

    private int playGame(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : ladder) {
            validateOutOfRange(currentPosition);
            currentPosition = movePosition(currentPosition, line);
        }

        return currentPosition;
    }

    private void validateOutOfRange(int currentPosition) {
        if(!(0 <= currentPosition && currentPosition <= widthOfLadder)) {
            throw new CustomException("참여자가 사다리를 벗어났습니다.");
        }
    }

    private int movePosition(int currentPosition, Line line) {
        return movePositionWhenCurrentIsZero(currentPosition, line);
    }

    private int movePositionWhenCurrentIsZero(int currentPosition, Line line) {
        if (currentPosition == 0) {
            return movePositionCheckRight(currentPosition, line);
        }

        return movePositionWhenCurrentIsEnd(currentPosition, line);
    }

    private int movePositionWhenCurrentIsEnd(int currentPosition, Line line) {
        if (currentPosition == widthOfLadder) {
            return movePositionCheckLeft(currentPosition, line);
        }

        return movePositionWhenCurrentInMiddle(currentPosition, line);
    }

    private int movePositionWhenCurrentInMiddle(int currentPosition, Line line) {
        currentPosition = movePositionCheckRight(currentPosition, line);
        return movePositionCheckLeft(currentPosition, line);
    }

    private int movePositionCheckRight(int currentPosition, Line line) {
        if (line.get(rightPointOf(currentPosition))) {
            return currentPosition + 1 ;
        }
        return currentPosition;
    }

    private int movePositionCheckLeft(int currentPosition, Line line) {
        if (line.get(leftPointOf(currentPosition))) {
            return currentPosition - 1 ;
        }
        return currentPosition;
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
