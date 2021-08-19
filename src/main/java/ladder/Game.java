package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<String> names = InputView.inputNameOfUsers();
        int height = InputView.inputHeightOfLadder();

        Users users = new Users(names);

        Ladder ladder = new Ladder(height, names.size());

        new OutputView().printLadder(ladder);
    }
}
