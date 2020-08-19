package ladder.domain.core.line;

import java.util.Objects;

class Point implements Comparable<Point> {
    private Point nextPoint;
    private final int index;

    Point(int index) {
        this.index = index;
        nextPoint = empty();
    }

    private static final Point empty = new Point(-1);

    static Point empty() {
        return empty;
    }

    void link(Point otherPoint) {
        if (isEmptyNextPoint() && isNotEquals(otherPoint)) {
            this.nextPoint = otherPoint;
            otherPoint.link(this);
        }
    }

    Point linkingPoint() {
        return nextPoint;
    }

    boolean isEmptyNextPoint() {
        return empty.equals(nextPoint);
    }

    boolean isNotEmpty() {
        return isNotEquals(empty);
    }

    boolean isNotEquals(Point otherPoint){
        return !equals(otherPoint);
    }

    public int getIndex() {
        return index;
    }

    public boolean hasLink(){
        if (isEmptyNextPoint()) {
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
