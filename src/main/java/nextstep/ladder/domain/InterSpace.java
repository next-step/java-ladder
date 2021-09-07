package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.strategy.DrawLineStrategy;

public class InterSpace {

    private final boolean hasCrossLine;

    public InterSpace(boolean hasCrossLine) {
        this.hasCrossLine = hasCrossLine;
    }

    public static InterSpace getBlankInterSpace() {
        return new InterSpace(false);
    }

    public static InterSpace draw(DrawLineStrategy strategy) {
        return new InterSpace(strategy.draw());
    }

    public boolean hasCrossLine() {
        return hasCrossLine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InterSpace that = (InterSpace) o;
        return hasCrossLine == that.hasCrossLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasCrossLine);
    }
}
