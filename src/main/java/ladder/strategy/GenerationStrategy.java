package ladder.strategy;

import ladder.constant.Point;

import java.util.List;

public interface GenerationStrategy {

    List<Point> generatePoints(int count);
}
