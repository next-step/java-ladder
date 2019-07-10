package ladder.controller;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.Rewards;
import ladder.message.result.InputGamerNameMessage;
import ladder.message.result.InputGamersMessage;
import ladder.message.result.InputLadderSizeMessage;
import ladder.message.result.InputRewardMessage;
import ladder.message.result.ResultMessage;
import ladder.message.result.RewardMessage;
import ladder.view.MainView;

public class LadderController implements ILadderController {
    private final static String EMPTY_STRING = "";
    private final static String RESULT_DELIMITER = ":";
    private final static String ENTER = System.getProperty("line.separator");
    
    private final Gamers gamers = Gamers.newInstance();
    private final Rewards rewards = Rewards.newInstance();
    private final Ladder ladder = Ladder.newInstance();
    private final MainView mainView = new MainView(this);
    
    @Override
    public void action() {
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void inputGamers(String gamerNames) {
        gamers.addGamers(gamerNames);
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void inputReward(String reward) {
        rewards.addRewards(gamers, reward);
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void inputLadderSize(int ladderSize) {
        ladder.makeLadder(ladderSize, gamers);
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void callAfterResult() {
        mainView.render(new InputGamerNameMessage());
    }
    
    @Override
    public void inputGamerName(String gamerName) {
        if (gamers.isGamerNameAll(gamerName)) {
            mainView.render(getAllRewards());
            return;
        }
        mainView.render(new RewardMessage(rewards.getReward(gamerName, gamers, ladder)));
    }
    
    private RewardMessage getAllRewards() {
        return new RewardMessage(gamers.keyStream()
          .map(Gamer::getName)
          .map(name -> name + RESULT_DELIMITER + rewards.getReward(name, gamers, ladder))
          .reduce((info1, info2) -> info1 + ENTER + info2)
          .orElse(EMPTY_STRING));
    }
    
    private Message getInputStepMessage() {
        if (gamers.isGamerNamesNeeded()) {
            return new InputGamersMessage();
        }
        if (rewards.isRewardsNeeded()) {
            return new InputRewardMessage();
        }
        if (ladder.isLadderSizeNeeded()) {
            return new InputLadderSizeMessage();
        }
        return new ResultMessage(gamers.getGamerNames(), ladder, rewards.getRewardNames());
    }
}