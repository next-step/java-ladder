package nextstep.ladder;

public interface PointGenerator {
    Point nextPoint(Point current);
    Point first();
}
