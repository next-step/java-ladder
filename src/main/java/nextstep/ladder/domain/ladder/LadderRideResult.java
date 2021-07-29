package nextstep.ladder.domain.ladder;

import java.util.List;

public class LadderRideResult {
    private final List<LadderPosition> positions;

    private LadderRideResult(List<LadderPosition> positions) {
        this.positions = positions;
    }

    public static LadderRideResult from(List<LadderPosition> ladderPositions) {
        return new LadderRideResult(ladderPositions);
    }

}
