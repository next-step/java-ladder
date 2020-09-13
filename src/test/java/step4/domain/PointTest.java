package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
	private Point point;

	@DisplayName(value = "첫번째로 생성하는 점이 FALSE인지 확인")
	@Test
	void firstPoint() {
		point = Point.first();
		assertThat(point.isPoint()).isFalse();
	}

	@DisplayName(value = "이전 점이 TRUE일 때 FALSE인 점을 생성하는지 확인")
	@Test
	void nextPoint() {
		point = Point.first().next(true);
		assertThat(point.next().isPoint()).isFalse();
	}

}
