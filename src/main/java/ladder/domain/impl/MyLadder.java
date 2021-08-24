package ladder.domain.impl;

import java.util.List;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;
import ladder.dto.LadderResult;

public class MyLadder implements Ladder {

    private final int countOfPeople;
    private final List<Line> lines;

    public MyLadder(int countOfPeople, List<Line> lines) {
        this.countOfPeople = countOfPeople;
        this.lines = lines;
    }

    public static MyLadder of(int countOfPeople, List<Line> lines) {
        return new MyLadder(countOfPeople, lines);
    }

    @Override
    public LadderResult permute() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < countOfPeople; i++) {
            int target = permute(i);
            ladderResult.put(i, target);
        }
        return ladderResult;
    }

    private int permute(int source) {
        int target = source;
        for (Line line : lines) {
            target = line.permute(target);
        }
        return target;
    }
}
