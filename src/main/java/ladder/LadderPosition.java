package ladder;

import java.util.Objects;

public class LadderPosition {
    private static final int FIRST_POSITION = 0;
    private static final int VALUE_OF_POSITION_ONE = 1;

    private final int position;
    private final LadderLineDirection lineDirection;

    private LadderPosition(int position, LadderLineDirection lineDirection) {
        this.position = position;
        this.lineDirection = lineDirection;
    }

    public static LadderPosition of(int position, LadderLineDirection lineDirection) {
        return new LadderPosition(position, lineDirection);
    }

    public static LadderPosition first() {
        return of(FIRST_POSITION, LadderLineDirection.first());
    }

    public int computeNextPosition() {
        if (lineDirection.isLeftGo()) {
            return position - VALUE_OF_POSITION_ONE;
        } else if (lineDirection.isRightGo()) {
            return position + VALUE_OF_POSITION_ONE;
        } else {
            return position;
        }
    }

    public LadderPosition moveToNext() {
        int nextPosition = position + VALUE_OF_POSITION_ONE;
        LadderLineDirection nextDirection = lineDirection.next();
        return of(nextPosition, nextDirection);
    }

    public LadderPosition moveToLast() {
        int nextPosition = position + VALUE_OF_POSITION_ONE;
        LadderLineDirection lastDirection = lineDirection.last();
        return of(nextPosition, lastDirection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LadderPosition))
            return false;
        LadderPosition that = (LadderPosition) o;
        return position == that.position &&
               lineDirection.equals(that.lineDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, lineDirection);
    }
}
