package ladder.domain;

import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.core.message.Message;
import ladder.message.result.ResultMessage;
import ladder.message.result.RewardMessage;

public class Model {
    enum Step {
        GAMERS_STEP,
        LADDER_SIZE_STEP,
        REWARD_INPUT_STEP,
        RESULT_STEP,
        GAMER_NAME_INPUT_STEP,
        REWARD_STEP
    }
    private final static String FIND_ALL = "all";
    private final static String RESULT_DELIMITER = ":";
    private final static String ENTER = System.getProperty("line.separator");
    private final static String EMPTY_STRING = "";
    private Ladder ladder;
    private Gamers gamers;
    private Rewards rewards;
    private Step step;
    private RewardMessage rewardResponse;
    
    public Model() {
        step = Step.GAMERS_STEP;
    }
    
    public void newGamers(String gamerNames) {
        gamers = Gamers.from(gamerNames);
        step = Step.REWARD_INPUT_STEP;
    }
    
    public void newRewards(String reward) {
        rewards = Rewards.of(gamers.getSize(), reward);
        step = Step.LADDER_SIZE_STEP;
    }
    
    public void newLadder(int rowSize) {
        ladder = Ladder.from(rowSize, gamers.getSize());
        step = Step.RESULT_STEP;
    }
    
    public void findReward(String gamerName) {
        step = Step.REWARD_STEP;
        if (FIND_ALL.equals(gamerName)) {
            rewardResponse = new RewardMessage(getAllRewardInfo());
            return;
        }
        rewardResponse = new RewardMessage(getReward(gamerName));
    }
    
    private String getAllRewardInfo() {
        return gamers.keyStream()
            .map(Gamer::getName)
            .map(gamerName -> gamerName + RESULT_DELIMITER + getReward(gamerName))
            .reduce((info1, info2) -> info1 + ENTER + info2)
            .orElse(EMPTY_STRING);
    }
    
    private String getReward(String gamerName) {
        return rewards.getReward(ladder.getRewardNumber(gamers.getLineNumber(gamerName)));
    }
    
    public RewardMessage getRewardResponse() {
        return rewardResponse;
    }
    
    public Ladder getLadder() {
        return ladder;
    }
    
    public Gamers getGamers() {
        return gamers;
    }
    
    public Rewards getRewards() {
        return rewards;
    }
}
