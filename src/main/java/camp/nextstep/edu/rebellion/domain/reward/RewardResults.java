package camp.nextstep.edu.rebellion.domain.reward;

import camp.nextstep.edu.rebellion.domain.position.MovedPositions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RewardResults {
    private final List<RewardResult> rewardResults;

    private RewardResults(Rewards rewards, MovedPositions positions) {
        this.rewardResults = generateResult(rewards, positions);
    }

    public static RewardResults of(Rewards rewards, MovedPositions positions) {
        return new RewardResults(rewards, positions);
    }

    public List<RewardResult> getRewardResults() {
        return Collections.unmodifiableList(rewardResults);
    }

    private List<RewardResult> generateResult(Rewards rewards, MovedPositions positions) {
        return positions.getPositions()
                .stream()
                .map(p -> new RewardResult(p.getName(),
                        rewards.findNameByPosition(p.getFinalPosition())))
                .collect(Collectors.toList());
    }
}
