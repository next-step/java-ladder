package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderStep> ladderSteps;

    private Ladder(LadderDrawingSettings settings) {
        this.ladderSteps = Stream.generate(() -> new LadderStep(settings))
            .limit(settings.getLadderHeight())
            .collect(Collectors.toUnmodifiableList());
    }

    public static Ladder from(LadderDrawingSettings settings) {
        return new Ladder(settings);
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
