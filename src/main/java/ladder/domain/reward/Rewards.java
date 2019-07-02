package ladder.domain.reward;

import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final static String SPLIT_REGEX = ",";
    
    private List<Reward> rewards;
    
    private Rewards(int rewardSize, String rewardString) {
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
}
