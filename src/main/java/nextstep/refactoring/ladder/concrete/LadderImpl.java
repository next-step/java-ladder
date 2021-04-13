package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderResult;
import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;

import java.util.List;

public class LadderImpl implements Ladder {

    private final List<Line> lines;
    private final int numberOfPositions;

    public LadderImpl(List<Line> lines, int numberOfPositions) {
        this.lines = lines;
        this.numberOfPositions = numberOfPositions;
    }

    @Override
    public LadderResult run(Position startPosition) {
        Position lastPosition =
                lines.stream().reduce(startPosition,
                                      (position, line) -> line.move(position),
                                      (next, current) -> next);

        return new LadderResult(startPosition, lastPosition);
    }

    @Override
    public int numberOfPositions() {
        return numberOfPositions;
    }
}
