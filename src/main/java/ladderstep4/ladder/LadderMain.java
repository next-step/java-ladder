package ladderstep4.ladder;

import ladderstep4.ladder.domain.*;
import ladderstep4.ladder.ui.InputView;
import ladderstep4.ladder.ui.OutputView;

public class LadderMain {

    public static final String ALL = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.readNames());

        Prizes prizes = new Prizes(InputView.readPrizes());
        Height height = new Height(InputView.readHeight());

        Ladder ladder = new Ladder(new PlayerCount(players.size()), height);
        PlayResult playResult = ladder.play();

        ResultMatcher resultMatcher = new ResultMatcher(players, playResult, prizes);

        OutputView.printLadderGame(players, ladder, prizes);

        readNameAndPrintResult(resultMatcher);
    }

    private static void readNameAndPrintResult(ResultMatcher resultMatcher) {
        String name = InputView.readName();
        if (ALL.equalsIgnoreCase(name)) {
            OutputView.printResults(resultMatcher);
            return;
        }
        OutputView.printResult(resultMatcher.match(name));

        readNameAndPrintResult(resultMatcher);
    }
}
