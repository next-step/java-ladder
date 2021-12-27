package ladderstep4.ladder;

import ladderstep4.ladder.domain.*;
import ladderstep4.ladder.dto.LadderGameDto;
import ladderstep4.ladder.ui.InputView;
import ladderstep4.ladder.ui.OutputView;

public class LadderMain {

    public static final String ALL = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.readNames());

        Prizes prizes = new Prizes(InputView.readPrizes());
        Height height = new Height(InputView.readHeight());

        Ladder2 ladder2 = new Ladder2(new PlayerCount(players.size()), height);
        PlayResult playResult = ladder2.play();

        ResultMatcher resultMatcher = new ResultMatcher(players, playResult, prizes);

        OutputView.printLadderGame(players, ladder2, prizes);

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
