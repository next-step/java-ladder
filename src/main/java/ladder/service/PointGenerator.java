package ladder.service;

import ladder.domain.Point;

import java.util.List;

public interface PointGenerator {
    Point generate(int index, List<Point> points);
}
