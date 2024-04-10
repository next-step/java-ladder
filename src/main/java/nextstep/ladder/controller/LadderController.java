package nextstep.ladder.controller;

import static nextstep.ladder.view.InputView.inputJoinUserNames;
import static nextstep.ladder.view.InputView.inputLadderHeight;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public void play() {
        Users users = joinUsers();
        Ladder ladder = makeLadder(users.numberOfUsers());
        ResultView.printCreatedLadder(users, ladder);
    }

    private Users joinUsers() {
        return Users.join(inputJoinUserNames());
    }

    private Ladder makeLadder(int userCount) {
        return Ladder.generateLadder(userCount, inputLadderHeight());
    }

}
