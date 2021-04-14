package nextstep.refactoring.laddergame.concrete.reward;

import nextstep.refactoring.laddergame.engine.reward.RewardsDto;

import java.util.Collections;
import java.util.List;

public class RewardsDtoImpl implements RewardsDto {

    private final List<String> rewardList;

    public RewardsDtoImpl(List<String> rewardList) {
        this.rewardList = rewardList;
    }

    @Override
    public List<String> rewards() {
        return Collections.unmodifiableList(rewardList);
    }
}
