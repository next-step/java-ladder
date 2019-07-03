package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.message.gamer.GamerMessage;
import ladder.message.ladder.LadderSizeMessage;
import ladder.core.message.Message;
import ladder.message.result.ResultMessage;
import ladder.message.reward.RewardMessage;

public class Model {
    enum Step {
        GAMERS_STEP,
        LADDER_SIZE_STEP,
        REWARD_INPUT_STEP,
        RESULT_STEP;
    }
    
    private Ladder ladder;
    private Gamers gamers;
    private Rewards rewards;
    private Step step;
    
    public Model() {
        step = Step.GAMERS_STEP;
    }
    
    public void newGamers(String gamerNames) {
        gamers = Gamers.of(gamerNames);
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
    
    public void matchGamerReward() {
    
    }
    
    public Message getMessage() {
        switch (step) {
            case GAMERS_STEP:
                return new GamerMessage();
            case REWARD_INPUT_STEP:
                return new RewardMessage();
            case LADDER_SIZE_STEP:
                return new LadderSizeMessage();
            case RESULT_STEP:
                return new ResultMessage(gamers.getGamerNames(), ladder, rewards.getRewardNames());
            default:
                return new GamerMessage();
        }
    }
}
