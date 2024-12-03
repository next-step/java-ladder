package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Ladders {
    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public int size() {
        return ladders.size();
    }

    public Position resolveFinalPosition(Participant participant) {
        Position finalPosition = participant.getPosition().deepCopy();
        for (int lineIndex = 0; lineIndex < lineSize(); lineIndex++) {
            finalPosition = moveOrNot(finalPosition, lineIndex);
        }
        return finalPosition;
    }

    private Position moveOrNot(Position ladderFinalPosition, int lineIndex) {
        if (isMovableLadder(ladderFinalPosition, lineIndex)) {
            return ladderFinalPosition.move(resolveMoveDirection(ladderFinalPosition, lineIndex));
        }
        return ladderFinalPosition;
    }

    public boolean isMovableLadder(Position ladderPosition, int lineIndex) {
        return ladderAt(ladderPosition.value()).isMovable(getLeftLadder(ladderPosition), lineIndex);
    }

    public PositionDirection resolveMoveDirection(Position ladderPosition, int lineIndex) {
        return ladderAt(ladderPosition.value()).resolveMoveDirection(getLeftLadder(ladderPosition), lineIndex);
    }

    public Ladder ladderAt(int position) {
        return this.ladders.get(position);
    }

    private Optional<Ladder> getLeftLadder(Position position) {
        if (position.isFirst()) {
            return Optional.empty();
        }
        return Optional.of(ladders.get(position.value() - 1));
    }

    public Integer lineSize() {
        return Objects.isNull(ladders) || ladders.isEmpty() ? 0 : ladders.get(0).lineSize();
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
