package ladder.controller;

import ladder.core.controller.Controller;
import ladder.core.message.Request;
import ladder.domain.Model;
import ladder.message.gamer.GamerNamesDTO;
import ladder.message.ladder.LadderSizeDTO;
import ladder.message.result.GamerNameDTO;
import ladder.message.reward.RewardDTO;
import ladder.view.MainView;

public class LadderController implements Controller {
    private Model model;
    private MainView mainView;
    
    public LadderController() {
        model = new Model();
        mainView = new MainView(this);
    }
    
    private void inputGamers(GamerNamesDTO gamerNames) {
        model.newGamers(gamerNames.getGamerNames());
    }
    
    private void inputReward(RewardDTO reward) {
        model.newRewards(reward.getReward());
    }
    
    private void inputLadderSize(LadderSizeDTO ladderSize) {
        model.newLadder(ladderSize.getInputNumber());
        model.matchGamerReward();
    }
    
    private void inputGamerName(GamerNameDTO gamerName) {
        model.findReward(gamerName.getGamerName());
    }
    
    @Override
    public void action() {
        mainView.render(model.getMessage());
    }
    
    @Override
    public void input(Request data) {
        if (data instanceof GamerNamesDTO) {
            inputGamers((GamerNamesDTO) data);
        } else if (data instanceof RewardDTO) {
            inputReward((RewardDTO) data);
        } else if (data instanceof LadderSizeDTO) {
            inputLadderSize((LadderSizeDTO) data);
        } else if (data instanceof GamerNameDTO) {
            inputGamerName((GamerNameDTO) data);
        }
        
        mainView.render(model.getMessage());
    }
}