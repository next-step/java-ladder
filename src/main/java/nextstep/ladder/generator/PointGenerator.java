package nextstep.ladder.generator;

import java.util.List;

import nextstep.ladder.domain.Point;

public interface PointGenerator {
	List<Point> generate(int width, int height);
}
