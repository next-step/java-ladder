package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
	void trueNextPoint() {
		point = Point.first().next(true);
		assertThat(point.next().isPoint()).isFalse();
		assertThat(point.next(false).isPoint()).isFalse();
	}

	@DisplayName(value = "이전 점이 FALSE일 때 FALSE거나 TRUE인 점을 생성하는지 확인")
	@Test
	void falseNextPoint() {
		point = Point.first().next(false);
		assertThat(point.next(false).isPoint()).isFalse();
		assertThat(point.next(true).isPoint()).isTrue();
	}

	@DisplayName(value = "연속 TRUE일 때 에러 발생 확인")
	@Test
	void truetrueException() {
		assertThatIllegalArgumentException().isThrownBy(() -> Point.first().next(true).next(true))
				.withMessage("사다리 점은 연속해서 배치할 수 없습니다.");

	}
}
