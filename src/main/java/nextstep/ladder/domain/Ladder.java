package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderRow> ladderRows;

    private Ladder(LadderGameSettings settings) {
        this.ladderRows = Stream.generate(() -> new LadderRow(settings))
            .limit(settings.getLadderHeight())
            .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder from(LadderGameSettings settings) {
        return new Ladder(settings);
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }
}
