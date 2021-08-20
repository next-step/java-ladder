package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<String> names = InputView.inputNamesOfUsers();
        Users users = Users.of(names);
        int height = InputView.inputHeightOfLadder();

        Ladder ladder = new Ladder(names.size(), height);

        OutputView.printNames(users);
        OutputView.printLadder(ladder);
    }
}
