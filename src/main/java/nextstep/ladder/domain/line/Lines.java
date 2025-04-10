package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(LadderUsers ladderUsers, Height height) {
        this.lines = Stream.generate(() -> Line.createFromLadderUsers(ladderUsers))
            .limit(height.getValue())
            .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLines() {
        return lines.stream().map(Line::getLine).collect(Collectors.toList());
    }
}
