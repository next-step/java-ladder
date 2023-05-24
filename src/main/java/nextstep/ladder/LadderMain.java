package nextstep.ladder;

import nextstep.ladder.domain.line.*;
import nextstep.ladder.domain.line.generator.RandomLineGenerator;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Users users = inputView.askUserName();
        WinningCategories winningCategories = inputView.askWinningCategory();
        LadderHeight ladderHeight = new LadderHeight(inputView.askLadderHeight());
        Ladder ladder = new Ladder(
                new RandomLineGenerator(),
                ladderHeight,
                users
        );
        resultView.printLadder(ladder, ladderHeight, users);
        resultView.printWinningCategory(winningCategories);

        LadderGame ladderGame = new LadderGame(ladder, users);
        ladderGame.start();

        resultView.printResult(inputView.askWhoWinningCategory(), winningCategories, ladderGame.toResult());

    }
}
