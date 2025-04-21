package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public static void start() {
        Players players = new Players(InputView.readNames());
        Results results = InputView.readResults(players);
        Ladder ladder = new Ladder(InputView.readHeight(), players.size(), new RandomPointStrategy());
        LadderResults ladderResults = LadderResults.from(players, ladder, results);
        OutputView.printResult(ladderResults, ladder);

        while (true) {
            String name = InputView.askPlayerName();
            if ("all".equals(name)) {
                OutputView.printAllResults(ladderResults);
                break;
            }
            OutputView.printSingleResult(name, ladderResults);
        }
    }
}
