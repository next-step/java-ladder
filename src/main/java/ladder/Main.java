package ladder;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> users = InputView.createUsers();
        List<String> outcomes = InputView.createOutcomes();
        int ladderHeight = InputView.createLadderHeight();

        LadderGame game = new LadderGame();
        Ladder ladder = game.createLadder(users, outcomes, ladderHeight);

        GameResult gameResult = game.run(ladder);
        ResultView.printLadder(ladder);

        String inputValue = InputView.createResult();
        ResultView.printResult(gameResult.findOutcome(inputValue));

    }
}
