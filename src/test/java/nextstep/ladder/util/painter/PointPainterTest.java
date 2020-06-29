package nextstep.ladder.util.painter;

import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.Points;

public class PointPainterTest {

	PointPainter painter;
	RandomPaintingStrategy randomPaintingStrategy;

	@BeforeEach
	void setUp() {
		randomPaintingStrategy = new RandomPaintingStrategy();
		painter = new PointPainter(randomPaintingStrategy);
	}

	@DisplayName("주어지는 수 만큼 좌표에 해당하는 페인터를 그린다.")
	@ValueSource(ints = {3, 50})
	@ParameterizedTest
	void 주어진_수만큼_좌표를_그린다(int count) {
		Points points = painter.drawPoints(count);
		assertThat(points.getSize()).isEqualTo(count);
	}

	@DisplayName("좌표는 연속으로 연결되지 않는다.")
	@Test
	void 좌표는_연속으로_연결되지_않는다() {
		Points points = painter.drawPoints(100);
		AtomicBoolean isContinuouslyConnected = new AtomicBoolean(false);
		points.getPoints().stream()
			.reduce((previous, next) -> {
				if (previous.isConnectedToNextPoint() && next.isConnectedToNextPoint()) {
					isContinuouslyConnected.set(true);
				}
				return next;
			});
		assertThat(isContinuouslyConnected.get()).isEqualTo(false);
	}

	@DisplayName("마지막 좌표는 다음 좌표와 연결되지 않는다.")
	@Test
	void 마지막_좌표는_다음_좌표와_연결되지_않는다() {
		Points points = painter.drawPoints(100);
		Point point = points.getPoints().get(points.getSize() - 1);
		assertThat(point.isConnectedToNextPoint()).isEqualTo(false);
	}
}
