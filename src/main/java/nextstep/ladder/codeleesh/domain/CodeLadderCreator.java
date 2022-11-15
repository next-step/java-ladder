package nextstep.ladder.codeleesh.domain;

import nextstep.ladder.engine.LadderCreator;
import nextstep.ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class CodeLadderCreator implements LadderCreator {

    private final LineCreator lineCreator;

    public CodeLadderCreator(final LineCreator lineCreator) {

        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(final int countOfPerson, final int height) {

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new CodeLineCreator().create(countOfPerson));
        }
        return new Ladder(lines);
    }
}
