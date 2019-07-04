package ladder.domain;

import ladder.domain.ladderline.LadderLineFactory;
import ladder.domain.model.LadderLines;

public class DefaultLadderService implements LadderService {

    private final LadderLineFactory ladderLineFactory;

    public DefaultLadderService(LadderLineFactory ladderLineFactory) {
        this.ladderLineFactory = ladderLineFactory;
    }

    @Override
    public LadderLines createLadderLines(int size, int height) {
        return ladderLineFactory.create(size, height);
    }
}
