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
        ResultView.printResultHeader();
        ResultView.printResultBody(attendances, ladder);
    }
}
