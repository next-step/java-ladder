package ladder.domain.ladder;

import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;

public class Positions {

    private final List<Position> positions;

    private Positions(final List<Position> positions) {
        validatePositions(positions);
        this.positions = positions;
    }

    public static Positions of(List<Position> positions) {
        return new Positions(positions);
    }

    private void validatePositions(final List<Position> positions) {
        if (Objects.isNull(positions)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public Position indexOf(final Position position) {
        return positions.get(position.getPosition());
    }

    public int size() {
        return positions.size();
    }
}
