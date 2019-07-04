package ladder.engine.impl;

import ladder.engine.Ladder;
import ladder.engine.LadderResult;
import ladder.engine.Line;

import java.util.List;

public class DefaultLadder implements Ladder {
    private final int sizeOfPerson;
    private final List<Line> lines;

    public DefaultLadder(final int sizeOfPerson, final List<Line> lines) {
        this.sizeOfPerson = sizeOfPerson;
        this.lines = lines;
    }

    @Override
    public LadderResult play() {
        LadderResult result = new LadderResult();
        for (int i = 0; i < sizeOfPerson; i++) {
            result.put(i, getTarget(i));
        }
        return result;
    }

    private int getTarget(int position) {
        int target = position;
        for (Line line : lines) {
            target = line.move(target);
        }
        return target;
    }
}
