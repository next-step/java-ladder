package ladderWithInterface.custom;

import ladderWithInterface.engin.Ladder;
import ladderWithInterface.engin.LadderResult;
import ladderWithInterface.engin.Line;

import java.util.Collections;
import java.util.List;

public class CustomLadder implements Ladder {

    private final int countOfPosition;
    private final List<Line> lines;

    public CustomLadder(List<Line> lines, int countOfPosition) {

        this.lines = lines;
        this.countOfPosition = countOfPosition;
    }


    @Override
    public LadderResult play() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < countOfPosition; i++) {
            ladderResult.put(i, move(i));
        }
        return ladderResult;
    }

    private int move(int position) {
        int target = position;
        for (Line line : lines) {
            target = line.move(target);
        }
        return target;
    }

    @Override
    public List<Line> draw() {
        return Collections.unmodifiableList(lines);
    }


}
