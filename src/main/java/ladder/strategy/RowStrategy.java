package ladder.strategy;

import ladder.domain.Point;

import java.util.List;

public interface RowStrategy {
    List<Point> generate(long size);
}
