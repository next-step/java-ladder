package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomDrawingPointsStrategyTest {

	@DisplayName("주어진 수만큼 좌표를 그린다")
	@ParameterizedTest
	@ValueSource(ints = {5, 50})
	void ladderLinePointsSize(int count) {
		RandomDrawingPointsStrategy drawingStrategy = new RandomDrawingPointsStrategy();
		LadderLinePoints points = drawingStrategy.draw(count);

		assertThat(points.size()).isEqualTo(count);
	}
}