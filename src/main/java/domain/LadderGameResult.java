package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderGameResult {

    private final List<Integer> positions;

    LadderGameResult(List<Integer> positions) {
        this.positions = positions;
    }

    public LadderGameResult move(Line line) {
        List<Integer> movedPositions = new ArrayList<>();

        for (Integer position : positions) {
            movedPositions.add(line.positionAfterMove(position));
        }

        return new LadderGameResult(movedPositions);
    }

    public Integer finalPositionOf(int userIndex) {
        return positions.get(userIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
