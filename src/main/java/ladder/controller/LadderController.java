package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private LadderController() {}

    public static void ladderCreator() {
        String names = InputView.inputUserName();
        int height = InputView.inputHeight();

        Users users = Users.of(names);
        Lines lines = new Ladder(users.countOfPerson(),height).createLines();

        ResultView.printGameResult(users,lines);
    }
}
