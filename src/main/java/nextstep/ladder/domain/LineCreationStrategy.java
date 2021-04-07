package nextstep.ladder.domain;

import java.util.List;

@FunctionalInterface
public interface LineCreationStrategy {

  List<Point> create();
}
