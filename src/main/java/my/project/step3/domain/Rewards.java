package my.project.step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    public static final String DELIMITER = ",";
    public static final String INPUT_REWARD_ALERT = "실행 결과를 확인해주십시요.(참여자 : %s, 실행 결과 : %s)";
    public static final int FOR_REMOVE_EMPTY = 2;

    private final List<Reward> rewards;

    public Rewards(Users users, String rewards) {
        List<Reward> rewardList = Arrays.stream(rewards.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
        validate(rewardList, users);
        this.rewards = rewardList;
    }

    private void validate(List<Reward> rewardList, Users users) {
        if (rewardList.size() != users.size()) {
            throw new IllegalArgumentException(String.format(INPUT_REWARD_ALERT, users.size(), rewardList.size()));
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward getReward(int ladderArrayIndex) {
        int listIndex = ladderArrayIndex / FOR_REMOVE_EMPTY;
        return rewards.get(listIndex);
    }
}
