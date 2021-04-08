package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.dto.LadderBoardDto;

public class LadderBoard {

    private final Ladder ladder;
    private final Rewards rewards;

    public LadderBoard(Ladder ladder, Rewards rewards) {
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Reward getReward(Player player) {
        return rewards.getReward(player.passThrough(ladder));
    }

    public LadderBoardDto export() {
        return new LadderBoardDto(ladder.export(), rewards.export());
    }

}
