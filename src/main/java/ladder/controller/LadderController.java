package ladder.controller;

import ladder.core.controller.Controller;
import ladder.domain.Model;
import ladder.view.MainView;

public class LadderController implements Controller {
    private Model model;
    private MainView mainView;
    
    public LadderController() {
        model = new Model();
        mainView = new MainView(this);
    }
    
    public void inputGamers(String gamerNames) {
        model.newGamers(gamerNames);
        mainView.render(model.getMessage());
    }
    
    public void inputLadderSize(int inputNumber) {
        model.newLadder(inputNumber);
        mainView.render(model.getMessage());
    }
    
    @Override
    public void action() {
        mainView.render(model.getMessage());
    }
}