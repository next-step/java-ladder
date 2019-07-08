package ladder.domain;

import ladder.common.PositiveNumber;
import ladder.domain.model.LadderLines;

public class DefaultLadderService implements LadderService {

    private final LadderLineFactory ladderLineFactory;

    public DefaultLadderService(LadderLineFactory ladderLineFactory) {
        this.ladderLineFactory = ladderLineFactory;
    }

    @Override
    public LadderLines createLadderLines(PositiveNumber countOfUsers, PositiveNumber height) {
        return ladderLineFactory.create(countOfUsers, height);
    }
}
