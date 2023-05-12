package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {

	@DisplayName("유효한 좌표 값으로 좌표 생성 시, 객체를 반환한다.")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test1(boolean input) {
		assertThat(Point.of(input)).isEqualTo(Point.of(input));
	}

	@DisplayName("좌표 객체는 매번 새로운 객체를 반환하지 않고 캐싱한다.")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void test2(boolean input) {
		assertThat(Point.of(input) == Point.of(input)).isTrue();
	}
}
