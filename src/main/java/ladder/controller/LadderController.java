package ladder.controller;

import ladder.core.controller.Controller;
import ladder.core.message.Request;
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
    
    private void inputGamers(GamerNames gamerNames) {
        model.newGamers(gamerNames.getGamerNames());
    }
    
    private void inputReward(RewardRequest reward) {
        model.newRewards(reward.getReward());
    }
    
    private void inputLadderSize(LadderSize ladderSize) {
        model.newLadder(ladderSize.getInputNumber());
    }
    
    private void inputGamerName(GamerName gamerName) {
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
    
    @Override
    public void input(Request data) {
        if (data instanceof GamerNames) {
            inputGamers((GamerNames) data);
        } else if (data instanceof RewardRequest) {
            inputReward((RewardRequest) data);
        } else if (data instanceof LadderSize) {
            inputLadderSize((LadderSize) data);
        } else if (data instanceof GamerName) {
            inputGamerName((GamerName) data);
        }
    }
}