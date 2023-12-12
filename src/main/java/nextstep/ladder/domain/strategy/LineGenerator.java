package nextstep.ladder.domain.strategy;

import java.util.List;

import nextstep.ladder.domain.Point;

public interface LineGenerator {
	List<Point> generate();
}
