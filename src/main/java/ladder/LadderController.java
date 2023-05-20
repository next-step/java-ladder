package ladder;


import ladder.Model.*;
import ladder.View.*;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> attendances = InputView.typeAttendances();
        Results results = InputView.typeResult(attendances.size());
        int maxHeight = InputView.typeMaxHeights();

        Ladder ladder = new Ladder(attendances, maxHeight);
        LadderGame game = new LadderGame(attendances, ladder);
        ResultMap resultMap = game.resultMap(ladder);

        ResultView.printResultHeader();
        ResultView.printAttendances(attendances);
        ResultView.printLadder(ladder);
        ResultView.printTypedResult(results);
        System.out.println("");
        InputView.typeLadderResult(resultMap, results);
    }
}
