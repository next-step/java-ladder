package nextstep.step4.impl;

import nextstep.step4.engine.Ladder;
import nextstep.step4.engine.LadderResult;
import nextstep.step4.engine.Line;

import java.util.List;

public class SimpsonLadder implements Ladder {
    private List<Line> lines;
    private final int countOfPerson;

    public SimpsonLadder(final List<Line> lines, final int countOfPerson) {
        this.lines = lines;
        this.countOfPerson = countOfPerson;
    }

    @Override
    public LadderResult play() {
        LadderResult result = new LadderResult();

        for (int source = 0; source < countOfPerson; source++) {
            int target = source;
            target = getTarget(target);
            result.put(source, target);
        }

        return result;
    }

    @Override
    public LadderResult play(final int source) {
        LadderResult result = new LadderResult();

        int target = source;
        result.put(source, getTarget(target));

        return result;
    }

    private int getTarget(int target) {
        for (Line line: lines) {
            target = line.move(target);
        }
        return target;
    }
}
