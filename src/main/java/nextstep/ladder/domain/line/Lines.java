package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> value;

    public Lines(LadderUsers ladderUsers, Height height, LineFactory lineFactory) {
        this.value = Stream.generate(() -> lineFactory.create(ladderUsers))
            .limit(height.getValue())
            .collect(Collectors.toList());
    }

    public List<List<Boolean>> getvalue() {
        return value.stream().map(Line::getValue).collect(Collectors.toList());
    }
}
