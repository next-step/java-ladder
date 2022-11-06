package nextstep.refactoring;

import nextstep.refactoring.strategy.RandomGenerator;
import nextstep.refactoring.user.User;
import nextstep.refactoring.user.Users;
import nextstep.refactoring.view.InputView;
import nextstep.refactoring.view.OutputView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Users users = InputView.getUserNames();
        List<String> executeResult = InputView.getExecuteResult();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(height, users.getSize(), new RandomGenerator());
        List<LadderResult> ladderResults = ladder.execute();

        OutputView.printLadderResultSentence();
        OutputView.printUsernames(users);
        OutputView.printLadder(ladder.getLines());
        OutputView.printResult(executeResult);

        while (true) {
            User inputUser = InputView.getUserNameForResult();
            OutputView.printExecuteResultSentence();
            if (inputUser.isSameName("all")) {
                OutputView.printAllResult(users, ladderResults, executeResult);
                continue;
            }
            OutputView.printGameResult(users, inputUser, ladderResults, executeResult);
        }
    }
}
