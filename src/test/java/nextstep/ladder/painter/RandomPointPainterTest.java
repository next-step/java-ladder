package nextstep.ladder.painter;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.point.Points;

public class RandomPointPainterTest {

	RandomPointPainter painter;

	@BeforeEach
	void setUp() {
		painter = new RandomPointPainter();
	}

	@DisplayName("주어지는 수 만큼 좌표에 해당하는 페인터를 그린다.")
	@ValueSource(ints = {3, 50})
	@ParameterizedTest
	void 주어진_수만큼_좌표를_그린다(int count) {
		Points points = painter.drawPoints(count);
		assertThat(points.getSize()).isEqualTo(count);
	}
}
