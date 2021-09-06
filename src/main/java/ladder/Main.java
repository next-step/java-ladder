package ladder;

import static ladder.view.InputView.inputLadderHeight;
import static ladder.view.InputView.inputUsernames;
import static ladder.view.ResultView.printResult;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.user.Users;
import ladder.strategy.RandomLineGenerateStrategy;

public class Main {

    public static void main(String[] args) {
        RandomLineGenerateStrategy lineGenerateStrategy = RandomLineGenerateStrategy.getInstance();

        Users users = Users.of(inputUsernames());
        Ladder ladder = Ladder.createLadder(new LadderHeight(inputLadderHeight()), users, lineGenerateStrategy);
        users.shuffleUsers();

        printResult(users.value(), ladder.value());
    }

}
