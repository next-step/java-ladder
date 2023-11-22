package ladder;

import ladder.domain.Gamers;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Result;
import ladder.domain.Results;
import ladder.stretagy.RandomPointStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        List<String> memberNames = InputView.requestJoinMembers();
        List<String> gameResults = InputView.requestResults();
        int totalLineCount = InputView.requestTotalLines();

        Gamers gamers = Gamers.createGamers(new Names(memberNames));
        Ladder ladder = Ladder.createLadder(totalLineCount, gamers, new RandomPointStrategy());
        Results results = new Results(gameResults, gamers.countGamers());

        OutputView.printLadder(gamers, ladder, results);

        LadderResult ladderResult = LadderResult.createLadderResult(gamers, results);

        while (true) {
            String name = InputView.requestResultGamer();
            Map<Name, Result> userResult = ladderResult.findPlayerResult(name);
            OutputView.printLadderResult(userResult, name);

            if (name.equals(LadderResult.ALL_USERS)) {
                break;
            }
        }
    }
}
