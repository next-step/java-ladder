package nextstep.ladder.generator;

import nextstep.ladder.domain.Point;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<Point> createLine(final int countOfPerson);
}
