package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.User;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.of(InputView.inputUser());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(LadderHeight.of(height), users.size());

        OutputView.printTitle();
        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
    }
}
