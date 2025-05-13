package nextstep.ladder2.domain.result;

import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.List;

public class MatchingResult {

    private List<Integer> playerRewardList;

    public MatchingResult(List<Integer> playerRewardList) {
        this.playerRewardList = playerRewardList;
    }

    public LadderResult map(Players players, Rewards rewards) {
        List<Reward> rewardList = new ArrayList<>();
        for (Integer idx: playerRewardList) {
            rewardList.add(rewards.get(idx));
        }

        return new LadderResult(players, rewardList);
    }

    public List<Integer> playerRewardList() {
        return playerRewardList;
    }
}
