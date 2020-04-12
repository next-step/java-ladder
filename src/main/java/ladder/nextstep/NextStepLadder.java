package ladder.nextstep;

import ladder.engine.Ladder;
import ladder.engine.LadderResult;
import ladder.engine.Line;

import java.util.List;

public class NextStepLadder implements Ladder {
    private final int sizeOfPerson;
    private final List<Line> lines;

    public NextStepLadder(final int sizeOfPerson, final List<Line> lines) {
        this.sizeOfPerson = sizeOfPerson;
        this.lines = lines;
    }

    @Override
    public LadderResult play() {
        LadderResult result = new LadderResult();
        for (int i = 0; i < sizeOfPerson; i++) {
            System.out.println("current position : " + i);
            result.put(i, getTarget(i));
        }
        return result;
    }

    private int getTarget(int position) {
        int target = position;
        for (Line line : lines) {
            System.out.println("current target : " + target);
            target = line.move(target);
        }
        return target;
    }
}
