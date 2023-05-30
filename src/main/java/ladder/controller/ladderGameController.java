package ladder.controller;

import ladder.domain.Users;
import ladder.view.OutputView;
import ladder.view.InputView;

public class ladderGameController {

    public static void main(String[] args) {
        OutputView.userNames();
        Users users = new Users(InputView.getStringValue());

        OutputView.ladderHeight();
        InputView.getIntValue();

        OutputView.result();
    }

}
