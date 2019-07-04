package ladder.domain;

import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.Ladder;
import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.message.response.result.GamerNameInput;
import ladder.message.response.gamer.GamerResponse;
import ladder.message.response.ladder.LadderSize;
import ladder.core.message.Response;
import ladder.message.response.result.Result;
import ladder.message.response.result.RewardResponse;
import ladder.message.response.reward.RewardInput;

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
    private RewardResponse rewardResponse;
    
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
        step = Step.REWARD_STEP;
        if (FIND_ALL.equals(gamerName)) {
            rewardResponse = new RewardResponse(getAllRewardInfo());
            return;
        }
        rewardResponse = new RewardResponse(getReward(gamerName));
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
    
    public Response getMessage() {
        switch (step) {
            case GAMERS_STEP:
                return new GamerResponse();
            case REWARD_INPUT_STEP:
                return new RewardInput();
            case LADDER_SIZE_STEP:
                return new LadderSize();
            case RESULT_STEP:
                step = Step.GAMER_NAME_INPUT_STEP;
                return new Result(gamers.getGamerNames(), ladder, rewards.getRewardNames());
            case GAMER_NAME_INPUT_STEP:
                return new GamerNameInput();
            case REWARD_STEP:
                step = Step.GAMER_NAME_INPUT_STEP;
                return rewardResponse;
            default:
                return new GamerResponse();
        }
    }
}
