package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private Users users;
    private Ladder ladder;

    public void run() {
        String user = InputView.printInputUsersMessage();
        users = Users.from(user);

        String ladderSize = InputView.printInputLadderMessage();
        ladder = Ladder.of(ladderSize, users.countOfPerson());

        ResultView.printResult();
        ResultView.printUsers(users.getUserNames());
        ResultView.printLadder(ladder.getLadder());
    }
}
