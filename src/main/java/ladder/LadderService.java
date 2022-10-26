package ladder;

import ladder.domain.person.People;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.ladder.ladderline.LadderLineFactory;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.ladder.strategy.LadderConnectStrategy;

public class LadderService {

    private final LadderLineFactory ladderLineFactory;

    public LadderService(LadderConnectStrategy ladderConnectStrategy) {
        this.ladderLineFactory = new LadderLineFactory(ladderConnectStrategy);
    }

    public LadderLines createLadderLine(int width, int height) {
        return ladderLineFactory.randomLadderLines(new LadderWidth(width), new LadderHeight(height));
    }

    public People people(String[] strings) {
        return new People(strings);
    }
}
