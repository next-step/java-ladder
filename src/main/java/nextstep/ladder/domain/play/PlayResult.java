package nextstep.ladder.domain.play;

import java.util.List;
import java.util.Objects;

public class PlayResult {
    private final List<PlayerPosition> positions;

    private PlayResult(List<PlayerPosition> positions) {
        validate(positions);
        this.positions = positions;
    }

    private void validate(List<PlayerPosition> positions) {
        if (Objects.isNull(positions)) {
            throw new IllegalArgumentException("positions는 null이면 안됩니다.");
        }
    }

    public static PlayResult of(List<PlayerPosition> positions) {
        return new PlayResult(positions);
    }

    public PlayerPosition result(PlayerPosition startPosition) {
        return positions.get(startPosition.getValue());
    }
}
