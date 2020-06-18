package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointPainterTest {

	@DisplayName("주어진 수만큼 좌표를 그린다")
	@ParameterizedTest
	@ValueSource(ints = {5, 50})
	void pointsSize(int count) {
		PointPainter pointsPainter = new PointPainter(() -> false);
		Points points = pointsPainter.drawPoints(count);

		assertThat(points.size()).isEqualTo(count);
	}

	@DisplayName("마지막 좌표는 다음 좌표와 연결되어 있지 않다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2})
	void lastPointIsNotConnectedToNext(int count) {
		PointPainter pointsPainter = new PointPainter(() -> false);
		Points points = pointsPainter.drawPoints(count);
		Point point = points.getContent().get(points.size() - 1);

		assertThat(point.isConnectedToNextPoint()).isFalse();
	}
}
