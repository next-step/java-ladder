package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {

    public static final int FIRST_PILLAR_OF_LADDER = 0;

    private final List<Line> ladder = new ArrayList<>();
    private final int widthOfLadder;

    public Ladder(int widthOfLadder, int heightOfLadder, LineStrategy lineStrategy) {
        this.widthOfLadder = widthOfLadder;

        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(widthOfLadder, lineStrategy));
        }
    }

    public List<Integer> result(){
        List<Integer> resultList = new ArrayList<>();

        for (int startPosition = FIRST_PILLAR_OF_LADDER; startPosition <= widthOfLadder; startPosition++) {
            int resultPosition = playGame(startPosition);
            resultList.add(resultPosition);
        }

        return resultList;
    }

    private int playGame(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : ladder) {
            currentPosition = line.movePosition(currentPosition);
        }

        return currentPosition;
    }

    public List<Line> ladder() {
        return Collections.unmodifiableList(ladder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder1 = (Ladder) o;
        return widthOfLadder == ladder1.widthOfLadder && Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder, widthOfLadder);
    }
}
