package step2;

import static step2.view.OutputView.*;
import static step2.view.InputView.*;

import step2.domain.Ladder;
import step2.domain.RandomLineStrategy;
import step2.domain.Users;

public class LadderApplication {

    public static void main(String[] args) {
        Users users = new Users(getUser());
        Ladder ladder = new Ladder(getHeight(), users.size(), new RandomLineStrategy());
        printResult();
        printUsers(users);
        printLadder(ladder);
    }
}
