package ladder.domain;

import ladder.util.StringUtil;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<String> rewards;

    @Builder
    public Rewards (String rewardInput, int countOfPlayers) {
        List<String> rewardInputs = StringUtil.convertList(rewardInput);
        validateRewards(rewardInputs, countOfPlayers);
        this.rewards = rewardInputs;
    }

    private void validateRewards(List<String> rewardInputs, int countOfPlayers) {
        if (rewardInputs.size() != countOfPlayers) {
        throw new IllegalArgumentException("참여자와 게임결과의 갯수가 다릅니다.");
        }
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public String getReward(Integer index) {
        return rewards.get(index);
    }
}
