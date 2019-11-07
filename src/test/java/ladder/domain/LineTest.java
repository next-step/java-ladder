package ladder.domain;

import ladder.util.PointUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LineTest {

	@Test
	void 선을_만들면_수직으로_연결된다() {
		// given
		Point point3 = Point.newInstance();
		Point point2 = Point.of(PointUtils.createNextPoints(Direction.VERTICAL, point3));
		Point point1 = Point.of(PointUtils.createNextPoints(Direction.VERTICAL, point2));
		Line expectedLine = Line.of(Arrays.asList(point1, point2, point3));

		// when
		Line createdLine = Line.of(1);

		// then
		assertThat(createdLine).isEqualTo(expectedLine);
	}

}
