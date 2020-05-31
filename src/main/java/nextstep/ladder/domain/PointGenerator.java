package nextstep.ladder.domain;

public interface PointGenerator {

    Point nextPoint(Point current);

    Point first();
}
