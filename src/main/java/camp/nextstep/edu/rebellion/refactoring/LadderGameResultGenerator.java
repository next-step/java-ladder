package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.RewardResults;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;

import java.util.List;

public class LadderGameResultGenerator {
    public RewardResults generateResult(Rewards rewards, RewardResults results) {
        return null;
    }

    public String getRunningResult(int startingPoint) {
        return rewards.findNameByPosition(
                ladder.getFinalPosition(startingPoint));
    }
}
