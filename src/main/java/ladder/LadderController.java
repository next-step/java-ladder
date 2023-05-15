package ladder;

import ladder.Model.LadderLine;
import ladder.Model.LadderMap;
import ladder.View.*;

import java.util.List;

public class LadderController {
    public void start() {
        List<String> attendances = InputView.TypeAttendances();
        int maxHeight = InputView.TypeMaxHeights();
        LadderMap ladderMap = new LadderMap(attendances.size(), maxHeight);
        for(LadderLine ladderline : ladderMap.ladderLines()){
            System.out.println(ladderline.lines());
        }
    }
}
