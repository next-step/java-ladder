package ladder.domain;

import java.util.*;
import static java.lang.Boolean.FALSE;

public class Point {

    private static final int FIRST_INDEX = 0;
    private static final int ADD_INDEX = 1;

    private final int index;
    private final Pointer pointer;

    private Point(int index, Pointer pointer) {
        this.index = index;
        this.pointer = pointer;
    }

    public static Point of(int index, Pointer pointer) {
        return new Point(index, pointer);
    }

    public static Point first(DirectionRule nextBooleanRule) {
        return of(FIRST_INDEX, Pointer.of(FALSE, nextBooleanRule.hasMovable()));
    }

    public static Point next(Point prePoint, DirectionRule nextBooleanRule) {
        int nextIndex = addIndex(prePoint);
        Pointer previous = pointer(prePoint);

        if (previous.isRight()) {
            return of(nextIndex, nextFalse(previous));
        }

        return of(nextIndex, Pointer.next(previous, nextBooleanRule.hasMovable()));
    }

    public static Point last(Point prePoint) {
        int nextIndex = addIndex(prePoint);
        Pointer previous = pointer(prePoint);

        return of(nextIndex, nextFalse(previous));
    }

    private static int addIndex(Point prePoint) {
        return (prePoint.getIndex() + ADD_INDEX);
    }

    private static Pointer pointer(Point prePoint) {
        return prePoint.getPointer();
    }

    private static Pointer nextFalse(Pointer prePoint) {
        return Pointer.next(prePoint, FALSE);
    }

    public int getIndex() {
        return index;
    }

    public Pointer getPointer() {
        return pointer;
    }

    public int movePoint(int position) {
        Pointer pointer = this.getPointer();
        if (pointer.isRight()) {
            return position + 1;
        }
        if (pointer.isLeft()) {
            return position - 1;
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(pointer, point.pointer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, pointer);
    }
}
