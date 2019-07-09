package ladder.controller;

import ladder.core.controller.ILadderController;
import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.info.Gamer;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.Rewards;
import ladder.message.EmptyMessage;
import ladder.message.result.InputGamerNameMessage;
import ladder.message.result.InputGamersMessage;
import ladder.message.result.InputLadderSizeMessage;
import ladder.message.result.InputRewardMessage;
import ladder.message.result.ResultMessage;
import ladder.message.result.RewardMessage;
import ladder.view.MainView;

public class LadderController implements ILadderController {
    private final static EmptyMessage EMPTY_MESSAGE = new EmptyMessage();
    private final static String EMPTY_STRING = "";
    private final static String RESULT_DELIMITER = ":";
    private final static String ENTER = System.getProperty("line.separator");
    private final static String FIND_ALL = "all";
    
    private final Gamers gamers;
    private final Ladder ladder;
    private final Rewards rewards;
    
    private final MainView mainView;
    
    public LadderController() {
        gamers = Gamers.newInstance();
        rewards = Rewards.newInstance();
        ladder = Ladder.newInstance();
        mainView = new MainView(this);
    }
    
    @Override
    public void action() {
        mainView.render(new InputGamersMessage());
    }
    
    @Override
    public void inputGamers(String gamerNames) {
        gamers.addGamers(gamerNames);
        mainView.render(new InputRewardMessage());
    }
    
    @Override
    public void inputReward(String reward) {
        rewards.addRewards(gamers, reward);
        mainView.render(new InputLadderSizeMessage());
    }
    
    @Override
    public void inputLadderSize(int ladderSize) {
        ladder.makeLadder(ladderSize, gamers);
        mainView.render(new ResultMessage(gamers.getGamerNames(), ladder, rewards.getRewardNames()));
    }
    
    @Override
    public void callAfterResult() {
        mainView.render(new InputGamerNameMessage());
    }
    
    @Override
    public void inputGamerName(String gamerName) {
        if (FIND_ALL.equals(gamerName)) {
            mainView.render(getAllRewards());
            return;
        }
        mainView.render(new RewardMessage(rewards.getReward(ladder.getRewardNumber(gamers.getLineNumber(gamerName)))));
    }
    
    
    private RewardMessage getAllRewards() {
        return new RewardMessage(gamers.keyStream()
          .map(Gamer::getName)
          .map(name -> name + RESULT_DELIMITER + rewards.getReward(ladder.getRewardNumber(gamers.getLineNumber(name))))
          .reduce((info1, info2) -> info1 + ENTER + info2)
          .orElse(EMPTY_STRING));
    }
}