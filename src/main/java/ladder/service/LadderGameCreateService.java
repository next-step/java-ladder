package ladder.service;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.ladder.strategy.LadderConnectStrategy;

public class LadderGameCreateService {

    private final LadderLineFactory ladderLineFactory;

    public LadderGameCreateService(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
    }

    public LadderLines createLadderLine(LadderWidth width, LadderHeight height) {
        return ladderLineFactory.randomLadderLines(width, height);
    }
}
