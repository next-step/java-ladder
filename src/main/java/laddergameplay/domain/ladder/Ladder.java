package laddergameplay.domain.ladder;

import laddergameplay.domain.datas.People;
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
            currentPosition = movePosition(line, currentPosition);
        }

        return currentPosition;
    }

    private int movePosition(Line line, int currentPosition) {
        int[] checkPointArr = {leftPointOf(currentPosition), rightPointOf(currentPosition)};
        int[] movedPositionArr = {moveLeft(currentPosition), moveRight(currentPosition)};

        for (int i = 0; i < checkPointArr.length; i++) {
            int checkPoint = checkPointArr[i];
            int movedPositionIfPoint = movedPositionArr[i];

            currentPosition = movePositionInALine(line, currentPosition, checkPoint, movedPositionIfPoint);
        }
        return currentPosition;
    }

    private int movePositionInALine(Line line, int currentPosition, int checkPoint, int movedPositionIfPoint) {
        if(checkPoint < FIRST_PILLAR_OF_LADDER || checkPoint >= lastPillarOfLadder || !line.get(checkPoint)) {
            return currentPosition;
        }

        return movedPositionIfPoint;
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
