package step4.strategy;

import step4.domain.Point;

import java.util.List;

public interface PointCreateStrategy {
    List<Point> create(int count);
}
