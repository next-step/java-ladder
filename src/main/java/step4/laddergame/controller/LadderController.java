package step4.laddergame.controller;

import step4.laddergame.domain.ladder.LadderWinning;

import static step4.laddergame.ui.InputView.inputWantName;
import static step4.laddergame.ui.ResultView.printWantResult;
import static step4.laddergame.ui.ResultView.printWantResults;

public class LadderController {

    public static boolean showResult(LadderWinning winning) {
        String name = inputWantName();
        if (name.equals("all")) {
            printWantResults(winning.getWinning());
            return false;
        }
        printWantResult(winning.findOne(name));
        return true;
    }
}

