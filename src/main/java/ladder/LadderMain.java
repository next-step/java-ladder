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
        checkPrintAllAndEnd(name, results);
        OutputView.printResult(results.resultOf(name));

        readNameAndPrintResult(results);
    }

    private static void checkPrintAllAndEnd(String name, Results results) {
        if (ALL.equalsIgnoreCase(name)) {
            OutputView.printResults(results);
            System.exit(0);
        }
    }

}
