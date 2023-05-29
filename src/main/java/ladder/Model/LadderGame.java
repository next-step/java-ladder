package ladder.Model;

import java.util.List;

public class LadderGame {
    public LadderGame(List<String> attendances, Ladder ladder) {
        ladder.moveDown(attendances);
    }

    public ResultMap resultMap(Ladder ladder) {
        return ladder.resultMap();
    }
}
