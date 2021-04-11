package nextstep.ladder.controller;

import nextstep.ladder.entity.Lines;
import nextstep.ladder.entity.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public void start() {

        String userInput = InputView.user();
        int ladderHeight = InputView.ladderHeight();

        Users users = new Users(userInput);

        Lines lines = new Lines(users.userCount(), ladderHeight);

        ResultView.printStart();
        ResultView.printUser(users.userNames());
        ResultView.printLadder(ladderHeight, lines.getLines());

    }
}
