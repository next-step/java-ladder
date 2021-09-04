package ladder.domain.application;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Users;
import ladder.strategy.LineGenerateStrategy;

public class LadderService {

    private final LineGenerateStrategy lineGenerateStrategy;

    public LadderService(LineGenerateStrategy lineGenerateStrategy) {
        this.lineGenerateStrategy = lineGenerateStrategy;
    }

    public Ladder createLadder(LadderHeight height, Users users) {
        return Ladder.createLadder(height, users, lineGenerateStrategy);
    }

}
