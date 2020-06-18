package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointsTest {

	@DisplayName("좌표 수보다 큰 위치에서 이동하려고 하면 IllegalArgumentException")
	@Test
	void moveSideFrom_greaterThanPointCount() {
		Point first = Point.first(false);
		Point second = first.next(false);
		Points points = Points.of(Arrays.asList(first, second));

		assertThatThrownBy(() -> points.moveSideFrom(2))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("좌표 수보다 큰 위치");
	}
}
