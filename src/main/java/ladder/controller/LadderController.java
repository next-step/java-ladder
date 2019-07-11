package ladder.controller;

import ladder.core.controller.ILadderController;
import ladder.core.message.Message;
import ladder.domain.gamer.Gamers;
import ladder.domain.ladder.LadderModel;
import ladder.domain.result.FinalResult;
import ladder.domain.reward.Rewards;
import ladder.message.InputGamerNameMessage;
import ladder.message.InputGamersMessage;
import ladder.message.InputLadderSizeMessage;
import ladder.message.InputRewardMessage;
import ladder.message.LadderResultMessage;
import ladder.message.ResultMessage;
import ladder.view.MainView;

public class LadderController implements ILadderController {
    private final Gamers gamers = Gamers.newInstance();
    private final Rewards rewards = Rewards.newInstance();
    private final LadderModel ladderModel = LadderModel.newInstance();
    private final FinalResult results = FinalResult.newInstance();
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
        rewards.setRewards(gamers, reward);
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void inputLadderSize(int ladderSize) {
        ladderModel.makeLadder(ladderSize, gamers);
        results.goToGoal(gamers, ladderModel, rewards);
        mainView.render(getInputStepMessage());
    }
    
    @Override
    public void callAfterLadderResult() {
        mainView.render(new InputGamerNameMessage());
    }
    
    @Override
    public void inputGamerName(String gamerName) {
        if (gamers.isGamerNameAll(gamerName)) {
            mainView.render(new ResultMessage(results.getAllResults()));
            return;
        }
        mainView.render(new ResultMessage(results.getResult(gamerName)));
    }
    
    private Message getInputStepMessage() {
        if (gamers.isGamerNamesNeeded()) {
            return new InputGamersMessage();
        }
        if (rewards.isRewardsNeeded()) {
            return new InputRewardMessage();
        }
        if (ladderModel.isLadderSizeNeeded()) {
            return new InputLadderSizeMessage();
        }
        return new LadderResultMessage(gamers.getGamerNames(), ladderModel, rewards.getRewardNames());
    }
}