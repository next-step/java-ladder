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
    
    private final List<Reward> rewards;
    
    public static Rewards newInstance() {
        return new Rewards();
    }
    
    private Rewards() {
        this.rewards = new ArrayList<>();
    }
    
    public List<String> getRewardNames() {
        return rewards.stream()
          .map(Reward::getReward)
          .collect(Collectors.toList());
    }
    
    public String getReward(int i) {
        if (i >= rewards.size()) {
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
