package nextstep.ladder.domain;

import java.util.List;

@FunctionalInterface
public interface PointsGenerateStrategy<T> {

    List<Point> generate(T pointParam);

}
