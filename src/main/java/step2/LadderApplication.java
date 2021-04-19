package step2;

import step2.domain.Ladder;
import step2.domain.RandomLineStrategy;
import step2.domain.Users;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Users users = new Users(InputView.getUser());
        Ladder ladder = new Ladder(InputView.getHeight(), users.size(), new RandomLineStrategy());
        OutputView.printResult(users,ladder);
    }
}
