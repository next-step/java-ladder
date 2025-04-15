package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void main(String[] args) {
        List<User> users = InputView.getUsers();
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = new Ladder(users.size(), ladderHeight);

        ResultView.printLadderGenerationResult(users, ladder);
    }
}
