package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;

public class LadderGameController {
    private InputView inputView;
    private LadderGame ladderGame;

    public LadderGameController() {
        inputView = new InputView();
        ladderGame = new LadderGame();
    }

    public void playLadderGame() {
        String names = inputView.readUserNames();
        int ladderHeight = inputView.readLadderHeight();
        UserNames userNames = ladderGame.creatUser(names);
    }
}
