package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.strategy.LineCreateStrategy;
import nextstep.ladder.domain.user.LadderUsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(LadderUsers ladderUsers, Height height, LineCreateStrategy lineCreateStrategy) {
        this.lines = Stream.generate(() -> new Line(ladderUsers, lineCreateStrategy))
            .limit(height.getValue())
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lines.stream()
            .map(Line::toString)
            .collect(Collectors.joining("\n"));
    }
}
