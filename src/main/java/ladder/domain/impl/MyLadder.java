package ladder.domain.impl;

import java.util.List;
import ladder.domain.engine.Ladder;
import ladder.domain.engine.Line;
import ladder.dto.LadderResult;

public class MyLadder implements Ladder {

    private final List<Line> lines;

    public MyLadder(List<Line> lines) {
        this.lines = lines;
    }

    public static MyLadder of(List<Line> lines) {
        return new MyLadder(lines);
    }

    @Override
    public LadderResult permute() {
        // TODO
        LadderResult ladderResult = new LadderResult();
        return ladderResult;
    }
}
