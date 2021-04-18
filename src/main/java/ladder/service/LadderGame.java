package ladder.service;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static void run() {
        List<String> users = InputView.getUsers();
        int height = InputView.getLadderHeight();
        Ladder ladder = Ladder.valueOf(users.size(), height);
        ResultView.printLadder(ladder, users);
    }
}
