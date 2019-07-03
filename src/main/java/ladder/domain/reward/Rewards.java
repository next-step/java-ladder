package ladder.domain.reward;

import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {
    private final static String SPLIT_REGEX = ",";
    private final static int MIN_REWARD_SIZE = 1;
    private final static int START_NUMBER = 1;
    
    private final Map<Integer, Reward> rewards;
    
    private Rewards(int rewardSize, String rewardString) {
        if (rewardSize < MIN_REWARD_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_ZERO.message());
        }
        String[] rewards = rewardString.split(SPLIT_REGEX);
        if (rewards.length != rewardSize) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCH_COUNT.message());
        }
        this.rewards = new HashMap<>();
        IntStream.range(START_NUMBER, rewards.length)
          .forEach(index -> this.rewards.put(index, Reward.from(rewards[index])));
    }
    
    public static Rewards of(int rewardSize, String rewardString) {
        return new Rewards(rewardSize, rewardString);
    }
    
    public List<String> getRewardNames() {
        return rewards.keySet().stream()
          .map(index -> rewards.get(index).getReward())
          .collect(Collectors.toList());
    }
    
    public int getSize() {
        return rewards.size();
    }
}
