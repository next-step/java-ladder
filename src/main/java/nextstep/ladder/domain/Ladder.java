package nextstep.ladder.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int height, int groupCount) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> LadderLine.of(groupCount))
                .collect(Collectors.toList()));
    }

    public Collection<Collection<Boolean>> ladderLines() {
        return ladderLines.stream()
                .map(LadderLine::ladderLine)
                .collect(Collectors.toUnmodifiableList());
    }
}
