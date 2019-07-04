package ladder.controller;

import ladder.core.controller.Controller;
import ladder.domain.Model;
import ladder.message.request.gamer.GamerNames;
import ladder.message.request.ladder.LadderSize;
import ladder.message.request.result.GamerName;
import ladder.message.request.reward.RewardRequest;
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
    }
    
    @Override
    public void inputGamers(GamerNames gamerNames) {
        model.newGamers(gamerNames.getGamerNames());
    }
    
    @Override
    public void inputReward(RewardRequest reward) {
        model.newRewards(reward.getReward());
    }
    
    @Override
    public void inputLadderSize(LadderSize ladderSize) {
        model.newLadder(ladderSize.getInputNumber());
    }
    
    @Override
    public void inputGamerName(GamerName gamerName) {
        String name = gamerName.getGamerName();
        if (EXIT_PROGRAM.equals(name)) {
            isExit = true;
            return;
        }
        model.findReward(gamerName.getGamerName());
    }
    
    @Override
    public void action() {
        while (!isExit) {
            mainView.render(model.getMessage());
        }
    }
}