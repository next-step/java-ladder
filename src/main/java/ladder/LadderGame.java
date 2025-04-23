package ladder;

import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public static void start() {
        Players players = new Players(InputView.readNames());
        Results results = InputView.readResults(players);
        Ladder ladder = new Ladder(InputView.readHeight(), players.size(), new RandomPointStrategy());
        OutputView.printResult(players, ladder, results);

        LadderResults ladderResults = LadderResults.from(players, ladder, results);
        while (true) {
            Player player = InputView.askPlayerName();
            if (player.isSameName("all")) {
                OutputView.printAllResults(ladderResults);
                break;
            }
            OutputView.printSingleResult(player, ladderResults);
        }
    }
}
