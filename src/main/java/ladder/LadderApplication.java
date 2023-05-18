package ladder;

import ladder.domain.Ladder;
import ladder.domain.RandomLineStrategy;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        Users users = new Users(InputView.enterNames());
        int height = InputView.enterHeight();

        Ladder ladder = new Ladder(users.count(), height, new RandomLineStrategy());
        OutputView.outputLadder(users, ladder);
    }

}
