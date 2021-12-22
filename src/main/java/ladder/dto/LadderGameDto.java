package ladder.dto;

import ladder.domain.*;

public class LadderGameDto {

    private final Names names;
    private final Ladder ladder;
    private final Rewards rewards;

    public LadderGameDto(Names names, Ladder ladder, Rewards rewards) {
        this.names = names;
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Rewards getRewards() {
        return rewards;
    }

}
