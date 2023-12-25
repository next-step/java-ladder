package nextstep.ladder;

import nextstep.ladder.domain.LineCreator;
import nextstep.ladder.domain.RandomLineCreator;

public class LadderGameConfig {
    private final LineCreator lineCreator;

    public LadderGameConfig() {
        this.lineCreator = new RandomLineCreator();
    }

    public LineCreator getLineCreator() {
        return lineCreator;
    }
}
