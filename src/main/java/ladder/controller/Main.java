package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderSession;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {

    public static void main(String[] args) {
        String userNames = InputView.getUserNames();
        Users users = new Users(userNames);

        int height = InputView.getHeight();
        Ladder ladder = new Ladder(users.size(), height);

        LadderSession session = new LadderSession(users, ladder);
        OutputView.printLadderSession(session);
    }
}
