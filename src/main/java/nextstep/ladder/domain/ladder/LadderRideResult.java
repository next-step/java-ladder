package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;

public class LadderRideResult {
    private final List<LadderPosition> positions;

    private LadderRideResult(List<LadderPosition> positions) {
        validate(positions);
        this.positions = positions;
    }

    private void validate(List<LadderPosition> positions) {
        if (Objects.isNull(positions)) {
            throw new NullArgumentException("LadderPositions");
        }
    }

    public static LadderRideResult from(List<LadderPosition> ladderPositions) {
        return new LadderRideResult(ladderPositions);
    }

    public LadderPosition endPositionOf(LadderPosition startPosition) {
        return positions.get(startPosition.toInt());
    }
}
