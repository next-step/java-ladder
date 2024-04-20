package nextstep.ladder.controller;

import static nextstep.ladder.view.InputView.inputJoinUserNames;
import static nextstep.ladder.view.InputView.inputLadderHeight;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public void play() {
        Users users = Users.join(inputJoinUserNames());
        Ladder ladder = Ladder.generateLadder(users.numberOfUsers(), inputLadderHeight());
        ResultView.printCreatedLadder(users, ladder);
    }
}
