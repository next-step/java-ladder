package ladderinterface.concrete;

import ladderinterface.engine.Ladder;
import ladderinterface.engine.LadderResult;
import ladderinterface.engine.Line;

import java.util.List;

public class StepLadder implements Ladder {
    private final int countOfPlayer;
    private final List<Line> lines;

    private StepLadder(int countOfPlayer, List<Line> lines) {
        this.countOfPlayer = countOfPlayer;
        this.lines = lines;
    }

    public static StepLadder of(int countOfPlayer, List<Line> lines) {
        return new StepLadder(countOfPlayer, lines);
    }

    @Override
    public LadderResult play() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < countOfPlayer; i++) {
            ladderResult.put(i, getTarget(i));
        }
        return ladderResult;
    }

    private int getTarget(int startPoint) {
        int target = startPoint;
        for (Line line : lines) {
            target = line.move(target);
        }
        return target;
    }
}
