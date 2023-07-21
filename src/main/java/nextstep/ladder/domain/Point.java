package nextstep.ladder.domain;

public class Point {

    private static final String MOVABLE_LINE = "------|";
    private static final String IMMOVABLE_LINE = "      |";

    private final Boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    @Override
    public String toString() {
        if (point){
            return MOVABLE_LINE;
        }

        return IMMOVABLE_LINE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point1 = (Point) o;

        return point.equals(point1.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }
}
