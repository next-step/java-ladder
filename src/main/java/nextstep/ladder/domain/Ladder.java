package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(int ladderHeight, int ladderWidth) {
        this.ladderRows = Stream.generate(() -> new LadderRow(ladderWidth))
            .limit(ladderHeight)
            .collect(Collectors.toUnmodifiableList());
    }
}
