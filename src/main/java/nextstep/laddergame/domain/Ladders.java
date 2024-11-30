package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;

import java.util.List;
import java.util.Objects;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public int size() {
        return ladders.size();
    }

    public boolean isMovableLadder(Position ladderPosition, int lineIndex) {
        int positionValue = ladderPosition.value();
        if (ladders.get(positionValue).isLineAlreadySetAt(lineIndex)) {
            return true;
        }
        if (ladderPosition.isNotFirst() && getLeftLadder(ladderPosition).isLineAlreadySetAt(lineIndex)) {
            return true;
        }
        return false;
    }

    public PositionDirection resolveMoveDirection(Position ladderPosition, int lineIndex) {
        if (ladderAt(ladderPosition.value()).isLineAlreadySetAt(lineIndex)) {
            return PositionDirection.RIGHT;
        }
        if (ladderPosition.isNotFirst() && getLeftLadder(ladderPosition).isLineAlreadySetAt(lineIndex)) {
            return PositionDirection.LEFT;
        }
        throw new IllegalArgumentException("사다리 라인이 놓여있지 않습니다.");
    }

    public Ladder ladderAt(int position) {
        return this.ladders.get(position);
    }

    private Ladder getLeftLadder(Position position) {
        return ladders.get(position.value() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladders ladders1 = (Ladders) o;
        return Objects.equals(ladders, ladders1.ladders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladders);
    }
}
