package nextstep.ladder2.domain.result;

import nextstep.ladder2.domain.ladder.Position;
import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.List;

public class MatchingResult {

    private List<Position> playerRewardList;

    public MatchingResult(List<Position> playerRewardList) {
        this.playerRewardList = playerRewardList;
    }

    public LadderResult map(Players players, Rewards rewards) {
        List<Reward> rewardList = new ArrayList<>();
        for (Position position: playerRewardList) {
            rewardList.add(rewards.get(position.value()));
        }

        return new LadderResult(players, rewardList);
    }

    public List<Position> playerRewardList() {
        return playerRewardList;
    }
}
