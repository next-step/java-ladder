package ladder.controller;

import ladder.core.controller.Controller;
import ladder.domain.Model;
import ladder.message.gamer.GamerNamesDTO;
import ladder.message.ladder.LadderSizeDTO;
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
        mainView.render(model.getMessage());
    }
    
    private void inputLadderSize(LadderSizeDTO ladderSize) {
        model.newLadder(ladderSize.getInputNumber());
        mainView.render(model.getMessage());
    }
    
    @Override
    public void action() {
        mainView.render(model.getMessage());
    }
    
    @Override
    public void input(Object data) {
        if (data instanceof GamerNamesDTO) {
            this.inputGamers((GamerNamesDTO) data);
            return;
        }
        
        if (data instanceof LadderSizeDTO) {
            this.inputLadderSize((LadderSizeDTO) data);
            return;
        }
    }
}