package nextstep.step4.impl;

import nextstep.step4.engine.Ladder;
import nextstep.step4.engine.LadderCreator;
import nextstep.step4.engine.Line;
import nextstep.step4.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class SimpsonLadderCreator implements LadderCreator {
    private final LineCreator lineCreator;

    public SimpsonLadderCreator(final LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(final int countOfPerson, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(lineCreator.create(countOfPerson));
        }

        return new SimpsonLadder(lines, countOfPerson);
    }
}
