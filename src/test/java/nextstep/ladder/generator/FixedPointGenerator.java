package nextstep.ladder.generator;

import java.util.Collections;
import java.util.List;

import nextstep.ladder.domain.Point;

public class FixedPointGenerator implements PointGenerator {
	@Override
	public List<Point> generate(int width, int height) {
		return Collections.nCopies(width * height, Point.createHasNotLine());
	}
}
