package ladder.domain.core.line.move;

import java.util.Objects;

class Point implements Comparable<Point> {
    private final int index;
    private Point nextPoint;

    Point(int index) {
        this.index = index;
        nextPoint = empty();
    }

    Point(int index, Point nextPoint) {
        this.nextPoint = nextPoint;
        this.index = index;
    }

    public static final int EMPTY_INDEX = -1;
    private static final Point empty = new Point(EMPTY_INDEX, null);

    static Point empty() {
        return empty;
    }

    void link(Point otherPoint) {
        if (isNotLinkNextPoint() && isNotEquals(otherPoint)) {
            this.nextPoint = otherPoint;
            otherPoint.link(this);
        }
    }

    Point linkingPoint() {
        return nextPoint;
    }

    boolean isNullNextPoint() {
        return null == nextPoint;
    }

    boolean isNotLinkNextPoint() {
        return isNullNextPoint() || empty.equals(nextPoint);
    }

    boolean isNotEmpty() {
        return index != EMPTY_INDEX && isNotEquals(empty);
    }

    boolean isNotEquals(Point otherPoint){
        return !equals(otherPoint);
    }

    public int getIndex() {
        return index;
    }

    public boolean hasLink(){
        if (isNotLinkNextPoint()) {
            return false;
        }
        return 0 > compareTo(linkingPoint());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(index);
    }

    @Override
    public int compareTo(Point o) {
        return index - o.index;
    }

    @Override
    public String toString() {
        return "Point{" +
            "index=" + index +
            '}';
    }
}
