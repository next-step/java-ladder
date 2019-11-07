package ladder.domain;

import ladder.util.PointUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class PointTest {

	@Test
	void 점들이_수평으로_연결된다() {
		// given
		Point point1 = Point.newInstance();
		Point point2 = Point.newInstance();

		Point point3 = Point.of(PointUtils.createNextPoints(Direction.HORIZONTAL, point2));
		Point point4 = Point.of(true);

		// when
		point1.connectStepWithAdjacentPoint(point2, () -> true);

		// then
		assertThat(point1).isEqualTo(point3);
		assertThat(point2).isEqualTo(point4);
	}

	@Test
	void 진작_수평으로_연결된_점이_있으면_다시_수평으로_점을_연결하지_않는다() {
		// given
		Point point1 = Point.of(new HashMap<>());
		Point point2 = Point.of(new HashMap<>());
		Point point3 = Point.of(new HashMap<>());

		Point point4 = Point.of(PointUtils.createNextPoints(Direction.HORIZONTAL, point2));
		Point point5 = Point.of(true);
		Point point6 = Point.of(false);

		// when
		point1.connectStepWithAdjacentPoint(point2, () -> true);
		point2.connectStepWithAdjacentPoint(point3, () -> true);

		// then
		assertThat(point1).isEqualTo(point4);
		assertThat(point2).isEqualTo(point5);
		assertThat(point3).isEqualTo(point6);
	}

}
