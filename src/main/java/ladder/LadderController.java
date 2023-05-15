package ladder;

import ladder.View.*;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> attendances = InputView.TypeAttendances();
        int maxHeight = InputView.TypeMaxHeights();
        System.out.println(attendances);
        System.out.println(maxHeight);
    }
}
