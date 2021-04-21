package ladder.domain;

import java.util.List;

public interface PointGenerator {
    List<Point> generate(int width);
}
