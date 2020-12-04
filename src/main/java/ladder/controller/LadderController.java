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
        Lines lines = Lines.of(users.countOfPerson(),height);

        ResultView.printGameResult(users,lines);
    }
}
