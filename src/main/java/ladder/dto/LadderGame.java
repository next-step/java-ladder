package ladder.dto;

import ladder.Results;
import ladder.domain.*;

public class LadderGame {

    private final LadderStrings<Name> names;
    private final Ladder ladder;
    private final LadderStrings<Reward> rewards;

    public LadderGame(String names, String rewards, int height) {
        this.names = new Names(names);
        this.ladder = new Ladder(this.names, height);
        this.rewards = new Rewards(rewards);
    }

    public LadderStrings<Name> getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderStrings<Reward> getRewards() {
        return rewards;
    }

    public Results play() {
        return null;
    }

}
