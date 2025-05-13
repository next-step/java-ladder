package nextstep.ladder2.domain.result;

import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.reward.Reward;

import java.util.List;

public class LadderResult {
    private final Players players;
    private final List<Reward> rewardList;

    public LadderResult(Players players, List<Reward> rewardList) {
        this.players = players;
        this.rewardList = rewardList;
    }

    public Players players() {
        return players;
    }

    public List<Reward> rewardList() {
        return List.copyOf(rewardList);
    }
}
