package nextstep.ladder.domain.ladder;

import java.util.List;

public class LadderRideResult {
    private final List<LadderPosition> positions;

    public LadderRideResult(List<LadderPosition> positions) {
        this.positions = positions;
    }

    public static Object from(List<LadderPosition> ladderPositions) {
        return null;
    }
}
