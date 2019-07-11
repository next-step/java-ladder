package ladder.domain.reward;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.LadderModel;
import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final static String SPLIT_REGEX = ",";
    
    private List<Reward> rewards;
    
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
    
    public Reward getReward(int i) {
        if (i >= rewards.size()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_INPUT_REWARD.message());
        }
        return rewards.get(i);
    }
    
    public Reward getReward(Gamer gamer, Gamers gamers, LadderModel ladderModel) {
        int lineNumber = gamers.getLineNumber(gamer);
        int goalNumber = ladderModel.getGoalNumber(lineNumber);
        return getReward(goalNumber);
    }
    
    public void setRewards(Gamers gamers, String rewardsString) {
        List<String> rewards = Arrays.asList(rewardsString.split(SPLIT_REGEX));
        if (!gamers.isSameSize(rewards.size())) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCH_COUNT.message());
        }
        this.rewards = rewards.stream().map(Reward::from).collect(Collectors.toList());
    }
    
    public boolean isRewardsNeeded() {
        return rewards.isEmpty();
    }
}
