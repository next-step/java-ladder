package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public static Ladder of(int userCount, Height height) {
        int heightCount = height.getHeight();
        return new Ladder(Stream.iterate(LadderLine.of(userCount),
                i -> LadderLine.of(userCount))
                .limit(heightCount)
                .collect(Collectors.toList()));
    }

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public Nodes exec(Users users) {
        Nodes nodes = users.createNodes();
        ladderLines.forEach(nodes::move);
        return nodes;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
