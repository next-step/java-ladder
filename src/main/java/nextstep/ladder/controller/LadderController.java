package nextstep.ladder.controller;

import nextstep.ladder.entity.Ladder;
import nextstep.ladder.entity.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public void start() {

        String userInput = InputView.user();
        int ladderHeight = InputView.ladderHeight();

        Users users = new Users(userInput);
        Ladder ladder = new Ladder(users.userCount(), ladderHeight);

        ResultView.printStart();
        ResultView.printUser(users.userNames());
        ResultView.printLadder(ladder);

    }
}
