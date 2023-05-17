package ladder;


import ladder.Model.Ladder;
import ladder.View.*;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> attendances = InputView.TypeAttendances();
        int maxHeight = InputView.TypeMaxHeights();
        Ladder ladder = new Ladder(attendances.size(), maxHeight);
        ResultView.printResultHeader();
        ResultView.printResultBody(attendances, ladder);
    }
}
