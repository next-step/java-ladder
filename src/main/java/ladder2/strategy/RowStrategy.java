package ladder2.strategy;

import ladder2.domain.Point;

import java.util.List;

public interface RowStrategy {
    List<Point> generate(long size);
}
