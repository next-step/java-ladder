package ladder.domain.reward;

import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final static String SPLIT_REGEX = ",";
    private final static int MIN_REWARD_SIZE = 1;
    
    private final List<Reward> rewards;
    
    private Rewards(int rewardSize, String rewardString) {
        if (rewardSize < MIN_REWARD_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_ZERO.message());
        }
        String[] rewards = rewardString.split(SPLIT_REGEX);
        if (rewards.length != rewardSize) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCH_COUNT.message());
        }
        this.rewards = Arrays.stream(rewards)
          .map(Reward::from)
          .collect(Collectors.toList());
    }
    
    public static Rewards of(int rewardSize, String rewardString) {
        return new Rewards(rewardSize, rewardString);
    }
    
    public List<String> getRewardNames() {
        return rewards.stream()
          .map(Reward::getReward)
          .collect(Collectors.toList());
    }
}
