package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public static Ladder of(Users users, Height height) {
        int heightCount = height.getHeight();
        int userCount = users.getUserCount();
        return new Ladder(Stream.iterate(LadderLine.of(userCount),
                i -> LadderLine.of(userCount))
                .limit(heightCount)
                .collect(Collectors.toList()));
    }

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
