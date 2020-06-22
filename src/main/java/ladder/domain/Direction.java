package ladder.domain;

import ladder.domain.moveStrategy.RandomGenerator;
import ladder.domain.moveStrategy.Shift;

import java.util.Objects;

public class Direction {

    public static final String CONNECTED_LINE_EXCEPTION = "가로라인은 겹치면 안됩니다.";

    private final boolean leftLine;
    private final boolean rightLine;

    private Direction(boolean leftLine, boolean rightLine) {
        validateDirection(leftLine, rightLine);
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    private void validateDirection(boolean leftLine, boolean rightLine) {
        if (leftLine && rightLine){
            throw new IllegalArgumentException(CONNECTED_LINE_EXCEPTION);
        }
    }

    public static Direction of(boolean leftLine, boolean rightLine){
        return new Direction(leftLine, rightLine);
    }

    public boolean leftLine(){
        return leftLine;
    }

    public boolean rightLine(){
        return rightLine;
    }

    public Direction next() {
        if (rightLine){
            return dicideLeft();
        }
        return decideRight(new RandomGenerator());
    }

    private Direction dicideLeft() {
        return of(true, false);
    }

    public static Direction decideRight(Shift moveStrategy) {
        return of(false, moveStrategy.next());
    }

    public Direction last() {
        if (rightLine){
            return dicideLeft();
        }
        return of(false, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return leftLine == direction.leftLine &&
                rightLine == direction.rightLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftLine, rightLine);
    }
}
