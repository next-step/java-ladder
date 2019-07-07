package ladder.controller;

import ladder.core.controller.Controller;
import ladder.domain.Model;
import ladder.message.EmptyMessage;
import ladder.message.result.ResultMessage;
import ladder.view.MainView;

public class LadderController implements Controller {
    private final static String EXIT_PROGRAM = "exit";
    private final Model model;
    private final MainView mainView;
    private boolean isExit;
    
    public LadderController() {
        model = new Model();
        mainView = new MainView(this);
        isExit = false;
        mainView.render(new EmptyMessage());
    }
    
    @Override
    public void inputGamers(String gamerNames) {
        model.newGamers(gamerNames);
        mainView.render(new EmptyMessage());
    }
    
    @Override
    public void inputReward(String reward) {
        model.newRewards(reward);
        mainView.render(new EmptyMessage());
    }
    
    @Override
    public void inputLadderSize(int ladderSize) {
        model.newLadder(ladderSize);
        mainView.render(new ResultMessage(model.getGamers().getGamerNames(), model.getLadder(), model.getRewards().getRewardNames()));
    }
    
    @Override
    public void inputGamerName(String gamerName) {
        if (EXIT_PROGRAM.equals(gamerName)) {
            isExit = true;
            return;
        }
        model.findReward(gamerName);
        mainView.render(model.getRewardResponse());
    }
    
    @Override
    public void action() {
        mainView.render(new EmptyMessage());
    }
}