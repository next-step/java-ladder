package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLinePointsTest {

	@DisplayName("좌표가 연속으로 연결되어 있으면 IllegalArgumentException")
	@Test
	void continuouslyConnectedPoints() {
		List<LadderLinePoint> points = Arrays.asList(
				LadderLinePoint.of(true),
				LadderLinePoint.of(true),
				LadderLinePoint.of(true));

		assertThatThrownBy(() -> LadderLinePoints.of(points))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("연속으로 연결");
	}
}