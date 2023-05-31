package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.OutputView;
import ladder.view.InputView;

public class ladderGameController {

    public static void main(String[] args) {
        OutputView.userNames();
        Users users = new Users(InputView.getStringValue());

        OutputView.ladderHeight();
        Ladder ladder = new Ladder(InputView.getIntValue(), users.count());

        OutputView.result(users, ladder);
    }

}
