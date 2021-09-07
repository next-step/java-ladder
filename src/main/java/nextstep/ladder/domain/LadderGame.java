package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {

    private final List<LadderStep> ladderSteps;

    private LadderGame(LadderGameSettings settings) {
        this.ladderSteps = Stream.generate(() -> new LadderStep(settings))
            .limit(settings.getLadderHeight())
            .collect(Collectors.toUnmodifiableList());
    }

    public static LadderGame from(LadderGameSettings settings) {
        return new LadderGame(settings);
    }

    public List<LadderStep> getLadderSteps() {
        return ladderSteps;
    }
}
