package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {
    private User user;


    public LadderGameController() {
        user = new User();
    }

    public void playLadderGame() {
        String names = InputView.readUserNames();
        LadderHeight ladderHeight = LadderGame.readLadderHeight(InputView.readLadderHeight());
        UserNames userNames = user.creatUser(names);

        LadderGame ladderGame = LadderGame.create(ladderHeight, userNames.count());

        ResultView.printMessage("실행결과");
        ResultView.printBlankLine();

        ResultView.printUserNames(userNames.userNames());
        ResultView.printLadder(ladderGame.toList());
    }
}
