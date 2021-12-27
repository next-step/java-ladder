package ladderstep4.ladder.dto;

import ladderstep4.ladder.domain.Ladder;
import ladderstep4.ladder.domain.Names;
import ladderstep4.ladder.domain.Rewards;

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
