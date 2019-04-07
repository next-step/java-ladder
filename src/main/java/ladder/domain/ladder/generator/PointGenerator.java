package ladder.domain.ladder.generator;

import ladder.domain.ladder.Point;

public interface PointGenerator {
    Point generate(Point previous);
    Point generateLeftmost();
    Point generateRightmost(Point previous);
}
