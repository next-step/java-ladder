package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderResult;
import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderImpl implements Ladder {

    private final List<Line> lines;

    public LadderImpl(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int numberOfPoints) {
        List<Line> lines = IntStream.of(0, height)
                                      .mapToObj(ignored -> LadderLine.init(numberOfPoints))
                                      .collect(Collectors.toList());

        return new LadderImpl(lines);
    }

    @Override
    public LadderResult run(Position startPosition) {
        Position lastPosition =
                lines.stream().reduce(startPosition,
                                      (position, line) -> line.move(position),
                                      (next, current) -> next);

        return new LadderResult(startPosition, lastPosition);
    }
}
