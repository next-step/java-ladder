package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Point;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int height, int groupCount) {
        return new Ladder(Stream.of(new LadderLine[height])
                .map(i -> LadderLine.of(groupCount))
                .collect(Collectors.toList()));
    }

    public Collection<Collection<Boolean>> ladderLines() {
        return ladderLines.stream()
                .map(LadderLine::lines)
                .collect(Collectors.toUnmodifiableList());
    }

    public Point play(Point toPlay) {
        Point result = toPlay;
        for (LadderLine ladderLine : ladderLines) {
            result = ladderLine.play(result);
        }
        return result;
    }
}
