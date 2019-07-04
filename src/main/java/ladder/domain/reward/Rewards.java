package ladder.domain.reward;

import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;

import java.util.ArrayList;
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
        this.rewards = new ArrayList<>();
        Arrays.stream(rewards).forEach(reward -> this.rewards.add(Reward.from(reward)));
    }
    
    public static Rewards of(int rewardSize, String rewardString) {
        return new Rewards(rewardSize, rewardString);
    }
    
    public List<String> getRewardNames() {
        return rewards.stream()
          .map(Reward::getReward)
          .collect(Collectors.toList());
    }
    
    public int getSize() {
        return rewards.size();
    }
    
    public String getReward(int i) {
        if (i >= getSize()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_INPUT_REWARD.message());
        }
        return rewards.get(i).getReward();
    }
}
