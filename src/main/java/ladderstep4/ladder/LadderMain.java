package ladderstep4.ladder;

import ladderstep4.ladder.domain.Ladder;
import ladderstep4.ladder.domain.Names;
import ladderstep4.ladder.domain.Results;
import ladderstep4.ladder.domain.Rewards;
import ladderstep4.ladder.dto.LadderGameDto;
import ladderstep4.ladder.ui.InputView;
import ladderstep4.ladder.ui.OutputView;

public class LadderMain {

    public static final String ALL = "all";

    public static void main(String[] args) {
        Names names = new Names(InputView.readNames());
        Rewards rewards = new Rewards(InputView.readRewards());
        int height = InputView.readHeight();

        Ladder ladder = new Ladder(names, height);
        Results results = new Results(names, ladder, rewards);

        OutputView.printLadderGame(new LadderGameDto(names, ladder, rewards));

        readNameAndPrintResult(results);
    }

    private static void readNameAndPrintResult(Results results) {
        String name = InputView.readName();
        if (ALL.equalsIgnoreCase(name)) {
            OutputView.printResults(results);
            return;
        }
        OutputView.printResult(results.resultOf(name));

        readNameAndPrintResult(results);
    }

}
