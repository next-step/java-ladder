package ladder.domain;

import ladder.exception.EmptyRewardException;
import ladder.exception.RewardToLessException;
import ladder.exception.RewardToManyException;
import ladder.utils.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reward {

    private final List<String> rewards;

    private Reward(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Reward of(String reward, int participantSize) {
        validate(reward, participantSize);
        return new Reward(makeRewards(reward));
    }

    private static List<String> makeRewards(String reward) {
        String[] rewardName = reward.split(",");

        return new ArrayList<>(Arrays.asList(rewardName));
    }

    private static void validate(String reward, int participantSize) {
        if (StringUtil.isEmpty(reward)) {
            throw new EmptyRewardException();
        }

        String[] rewardName = reward.split(",");
        if (rewardName.length < participantSize) {
            throw new RewardToLessException();
        }

        if (rewardName.length > participantSize) {
            throw new RewardToManyException();
        }
    }

    public List<String> getRewards() {
        return rewards;
    }
}
