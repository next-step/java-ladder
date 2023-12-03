package nextstep.step4.impl;

import nextstep.step4.engine.*;

import java.util.List;

public class SimpsonLadder implements Ladder {
    public static final String NEW_LINE = "\n";

    private final List<Line> lines;
    private final int countOfPerson;

    public SimpsonLadder(final List<Line> lines, final int countOfPerson) {
        this.lines = lines;
        this.countOfPerson = countOfPerson;
    }

    @Override
    public LadderResult play(Participants participants, Results results) {
        LadderResult ladderResult = new LadderResult();

        for (int i = 0; i < countOfPerson; i++) {
            int target = i;
            target = getTarget(target);
            ladderResult.put(participants.get(i), results.get(target));
        }

        return ladderResult;
    }

    private int getTarget(int target) {
        for (Line line: lines) {
            target = line.move(target);
        }
        return target;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.lines.forEach(l -> stringBuilder.append(l.toString()).append(NEW_LINE));

        return stringBuilder.toString();
    }
}
