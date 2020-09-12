package step04.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String INVALID_REWARDS_SIZE = "유저수 와 보상수가 일치하지 않습니다.";
    private static final String REWARD_ALIGN_FORMAT = "%-5s ";

    private final List<Reward> rewardList;

    public Rewards(List<Reward> rewardList, LadderUsers ladderUsers) {
        validateSize(rewardList, ladderUsers);
        this.rewardList = Collections.unmodifiableList(rewardList);
    }

    private void validateSize(List<Reward> rewards, LadderUsers ladderUsers) {
        if (!ladderUsers.isEqualSize(rewards.size())) {
            throw new IllegalArgumentException(INVALID_REWARDS_SIZE);
        }
    }

    public String printableRewardsStatus() {
        return rewardList.stream()
                .map(Reward::getName)
                .map(name -> String.format(REWARD_ALIGN_FORMAT, name))
                .collect(Collectors.joining());
    }

    public Reward getRewardByIndex(int index) {
        return rewardList.get(index);
    }
}
