package ladder.domain.point;

import ladder.domain.Direction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class PointTest {

	@Test
	void 점들이_수평으로_연결된다() {
		// given
		Point point = new MiddlePoint();
		Point nextPoint = new MiddlePoint();

		// when
		point.connectWithPointHorizontally(() -> true, nextPoint);

		// then
		assertThat(point.hasConnection(Direction.HORIZONTAL)).isTrue();
		assertThat(nextPoint.hasConnection(Direction.HORIZONTAL_REVERSE)).isTrue();
	}

	@Test
	void 진작_수평으로_연결된_점이_있으면_다시_수평으로_점을_연결하지_않는다() {
		// given
		Point point = new MiddlePoint();
		Point nextPoint = new MiddlePoint();
		Point finalPoint = new MiddlePoint();
		point.connectWithPointHorizontally(() -> true, nextPoint);

		// when
		nextPoint.connectWithPointHorizontally(() -> true, finalPoint);

		// then
		assertThat(finalPoint.hasConnection(Direction.HORIZONTAL)).isFalse();
		assertThat(finalPoint.hasConnection(Direction.HORIZONTAL_REVERSE)).isFalse();
	}

	@Test
	void 첫번째_줄에_있는_점은_수평으로_연결되지_않는다() {
		// given
		Point point = new FirstPoint("이름1");
		Point nextPoint = new FirstPoint("이름2");

		// when & then
		assertThatThrownBy(() -> point.connectWithPointHorizontally(() -> true, nextPoint))
		.isInstanceOf(IllegalStateException.class);
	}

	@Test
	void 마지막_줄에_있는_점은_수평으로_연결되지_않는다() {
		// given
		Point point = new LastPoint("결과");
		Point nextPoint = new LastPoint("결과");

		// when & then
		assertThatThrownBy(() -> point.connectWithPointHorizontally(() -> true, nextPoint))
				.isInstanceOf(IllegalStateException.class);
	}

}
