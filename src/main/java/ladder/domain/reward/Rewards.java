package ladder.domain.reward;

import ladder.domain.gamer.Gamers;
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
    
    private Rewards() {
        this.rewards = new ArrayList<>();
    }
    
    public static Rewards newInstance() {
        return new Rewards();
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
    
    public void addRewards(Gamers gamers, String rewardsString) {
        String[] rewards = rewardsString.split(SPLIT_REGEX);
        if (!gamers.isSameSize(rewards.length)) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCH_COUNT.message());
        }
        Arrays.stream(rewards).forEach(reward -> this.rewards.add(Reward.from(reward)));
    }
}
