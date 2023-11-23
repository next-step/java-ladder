package ladder;

import ladder.domain.GamersResult;
import ladder.domain.LadderResult;
import ladder.domain.Names;
import ladder.domain.Ladder;
import ladder.domain.Results;
import ladder.stretagy.RandomPointStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<String> memberNames = InputView.requestJoinMembers();
        List<String> gameResults = InputView.requestResults();
        int totalLineCount = InputView.requestTotalLines();

        Names joinMembers = new Names(memberNames);
        Ladder ladder = new Ladder(totalLineCount, joinMembers.countPlayers(), new RandomPointStrategy());
        Results results = new Results(gameResults, joinMembers.countPlayers());

        OutputView.printLadder(joinMembers, ladder, results);

        GamersResult gamersResult = GamersResult.createGamersResult(joinMembers, ladder);
        LadderResult ladderResult = LadderResult.createLadderResult(gamersResult, results);

        OutputView.printLadderResult(ladderResult);
    }
}
