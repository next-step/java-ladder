package nextstep.laddergame.domain;

import nextstep.laddergame.service.PositionDirection;

import java.util.Objects;
import java.util.Optional;

public class Ladder {
    private final Position position;
    private final Lines lines;


    public Ladder(int position, Lines lines) {
        this(new Position(position), lines);
    }

    public Ladder(Position position, Lines lines) {
        this.position = position;
        this.lines = lines;
    }

    public Position nextPosition() {
        return position.next();
    }

    public boolean isLineAlreadySetAt(int lineIndex) {
        return lines.isAlreadySetAt(lineIndex);
    }

    public boolean isMovable(Optional<Ladder> leftLadder, int lineIndex) {
        if (isLineAlreadySetAt(lineIndex)) {
            return true;
        }
        return leftLadder
                .filter(ladder -> ladder.isLineAlreadySetAt(lineIndex))
                .isPresent();
    }

    public PositionDirection resolveMoveDirection(Optional<Ladder> leftLadder, int lineIndex) {
        if (isLineAlreadySetAt(lineIndex)) {
            return PositionDirection.RIGHT;
        }
        return leftLadder
                .filter(ladder -> ladder.isLineAlreadySetAt(lineIndex))
                .map(ladder -> PositionDirection.LEFT)
                .orElseThrow(() -> new IllegalArgumentException("사다리 라인이 놓여있지 않습니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(position, ladder.position) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, lines);
    }

    public int lineSize() {
        return Objects.isNull(lines) ? 0 : lines.totalSize();
    }
}
