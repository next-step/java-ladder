package ladder;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderRecord;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> users = InputView.createUsers();
        List<String> outcomes = InputView.createOutcomes();
        int ladderHeight = InputView.createLadderHeight();

        LadderRecord ladderRecord = new LadderRecord(users, outcomes);

        LadderGame game = new LadderGame();
        Ladder ladder = game.createLadder(ladderRecord, ladderHeight);

        GameResult gameResult = game.run(ladderRecord, ladder);
        ResultView.printLadder(ladderRecord, ladder);

        String inputValue = InputView.createResult();
        ResultView.printResult(gameResult.findOutcome(inputValue));

    }
}
