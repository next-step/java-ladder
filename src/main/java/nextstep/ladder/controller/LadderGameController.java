package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;

public class LadderGameController {
    private InputView inputView;
    private User user;


    public LadderGameController() {
        inputView = new InputView();
        user = new User();
    }

    public void playLadderGame() {
        String names = inputView.readUserNames();
        LadderHeight ladderHeight = LadderCreator.readLadderHeight(inputView.readLadderHeight());
        UserNames userNames = user.creatUser(names);
    }
}
