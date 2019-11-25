package nextstep.ladder.domain.point;

import nextstep.UniformRandomBooleanProvider;

public class PointState {

    private final boolean hasLine;
    private final PointState previousPoint;

    public PointState(boolean hasLine, PointState previousPointState) {
        this.hasLine = hasLine;
        this.previousPoint = previousPointState;
    }

    public static PointState createForFirst() {
        return new PointState(UniformRandomBooleanProvider.getInstance().get(), null);
    }

    public PointState createNextStateWithNoLine() {
        return new PointState(false, this);
    }

    public PointState createNextState() {
        return new PointState(UniformRandomBooleanProvider.getInstance().get(), this);
    }

    public boolean canMovePrevious() {
        return previousPoint != null && previousPoint.hasLine();
    }

    public boolean canMoveNext() {
        return hasLine;
    }

    public boolean hasLine() {
        return hasLine;
    }
}
