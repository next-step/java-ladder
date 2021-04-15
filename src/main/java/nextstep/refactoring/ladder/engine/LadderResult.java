package nextstep.refactoring.ladder.engine;

import java.util.Objects;

public class LadderResult {

    private final Position startPosition;
    private final Position endPosition;

    public LadderResult(Position startPosition, Position endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(getStartPosition(), that.getStartPosition()) && Objects
            .equals(getEndPosition(), that.getEndPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartPosition(), getEndPosition());
    }
}
