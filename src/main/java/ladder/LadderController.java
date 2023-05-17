package ladder;


import ladder.Model.*;
import ladder.View.*;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> attendances = InputView.TypeAttendances();
        Results results = InputView.TypeResult(attendances.size());
        int maxHeight = InputView.TypeMaxHeights();

        Ladder ladder = new Ladder(attendances.size(), maxHeight);
        ResultMap resultMap = new LadderGame(attendances, ladder).resultMap();

        ResultView.printResultHeader();
        ResultView.printAttendances(attendances);
        ResultView.printLadder(ladder);
        ResultView.printTypedResult(results);

        System.out.println(resultMap.all());
    }
}
