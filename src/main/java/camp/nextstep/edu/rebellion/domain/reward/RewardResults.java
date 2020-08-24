package camp.nextstep.edu.rebellion.domain.reward;

import java.util.Collections;
import java.util.List;

public class RewardResults {
    private final List<RewardResult> rewardResults;

    public RewardResults(List<RewardResult> rewardResults) {
        this.rewardResults = rewardResults;
    }

    public List<RewardResult> getRewardResults() {
        return Collections.unmodifiableList(rewardResults);
    }
}
