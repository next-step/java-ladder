package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = User.of(InputView.inputUser());
        int ladderHeight = InputView.inputHeight();
        Ladder ladder = new Ladder(ladderHeight, users.size());

        OutputView.printTitle();
        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
    }
}
