package ladder;

import ladder.domain.*;
import ladder.dto.LadderGameDto;
import ladder.ui.InputView;
import ladder.ui.OutputView;

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
