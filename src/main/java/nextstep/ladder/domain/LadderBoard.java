package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.dto.LadderBoardDto;
import nextstep.ladder.dto.LadderDto;

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

    public LadderDto getLadder() {
        return ladder.export();
    }

    public LadderBoardDto export() {
        return new LadderBoardDto(ladder.export(), rewards.export());
    }

}
