package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.strategy.LadderStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<String> names = InputView.inputNameOfUsers();
        Users users = new Users(names);
        int height = InputView.inputHeightOfLadder();

        Ladder ladder = new Ladder(height, names.size());
        while (!LadderStrategy.validLadder(ladder)) {
            ladder = new Ladder(height, names.size());
        }

        OutputView.printNames(users);
        OutputView.printLadder(ladder);
    }
}
