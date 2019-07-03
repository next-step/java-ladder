package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.message.gamer.GamerResponse;
import ladder.message.ladder.LadderSizeResponse;
import ladder.core.message.Response;
import ladder.message.result.ResultResponse;
import ladder.message.reward.RewardResponse;

public class Model {
    enum Step {
        GAMERS_STEP,
        LADDER_SIZE_STEP,
        REWARD_INPUT_STEP,
        RESULT_STEP,
        RESULT_INPUT_STEP;
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
    
    public void findReward(String gamerName) {
    }
    
    
    public Response getMessage() {
        switch (step) {
            case GAMERS_STEP:
                return new GamerResponse();
            case REWARD_INPUT_STEP:
                return new RewardResponse();
            case LADDER_SIZE_STEP:
                return new LadderSizeResponse();
            case RESULT_STEP:
                return new ResultResponse(gamers.getGamerNames(), ladder, rewards.getRewardNames());
            default:
                return new GamerResponse();
        }
    }
}
