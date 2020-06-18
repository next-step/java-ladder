package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointPainterTest {

	@DisplayName("주어진 수만큼 좌표를 그린다")
	@ParameterizedTest
	@ValueSource(ints = {5, 50})
	void pointsSize(int count) {
		PointPainter pointsPainter = new PointPainter(() -> Point.of(false));
		Points points = pointsPainter.drawPoints(count);

		assertThat(points.size()).isEqualTo(count);
	}

	@DisplayName("좌표는 연속으로 연결되지 않는다")
	@Test
	void pointIsNotContinuouslyConnected() {
		PointPainter pointsPainter = new PointPainter(() -> Point.of(true));
		List<Point> points = pointsPainter.drawPoints(100).getContent();

		boolean isContinuouslyConnected = false;

		for (int i = 0; i < points.size() - 1; i++) {
			if (points.get(i).isConnectedToNextPoint() && points.get(i + 1).isConnectedToNextPoint()) {
				isContinuouslyConnected = true;
				break;
			}
		}

		assertThat(isContinuouslyConnected).isFalse();
	}

	@DisplayName("마지막 좌표는 다음 좌표와 연결되어 있지 않다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	void lastPointIsNotConnectedToNext(int count) {
		PointPainter pointsPainter = new PointPainter(() -> Point.of(true));
		Points points = pointsPainter.drawPoints(count);
		Point point = points.getContent().get(points.size() - 1);

		assertThat(point.isConnectedToNextPoint()).isFalse();
	}
}
