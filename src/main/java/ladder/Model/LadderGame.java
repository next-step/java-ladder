package ladder.Model;

import java.util.List;

public class LadderGame {
    public LadderGame(List<String> attendances, Ladder ladder) {
        int width = attendances.size();
        for (int idx = 0; idx < width; idx++) {
            ladder.moveDown(attendances.get(idx), idx);
        }
    }

    public ResultMap resultMap(Ladder ladder) {
        return ladder.resultMap();
    }
}
