package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private Names names;
    private Lines lines;

    public LadderGame(Names names, GenerateLadderPoint generateLadderPoint, Height height) {
        this.names = names;
        this.lines = createLines(names.size(), height, generateLadderPoint);
    }

    private Lines createLines(int namesSize, Height height, GenerateLadderPoint generateLadderPoint) {
        List<Line> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(namesSize, generateLadderPoint))
                .collect(Collectors.toList());
        return new Lines(lines);
    }
}
