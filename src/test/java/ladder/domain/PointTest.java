package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ladder.type.DirectionType;

public class PointTest {

	@DisplayName("움직일 방향을 결정한다.")
	@CsvSource(value = {"true,false,LEFT", "false,true,RIGHT", "false,false,DOWN"}, delimiter = ',')
	@ParameterizedTest
	void test1(boolean first, boolean next, DirectionType directionType) {
		Point point = Point.first(first).next(next);
		assertThat(point.direction()).isEqualTo(directionType);
	}

	@DisplayName("인접한 좌표를 모두 채울 경우, 예외를 던진다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> Point.first(true).next(true));
	}

	@DisplayName("이전 좌표가 true일 때, 다음 좌표를 구한다.")
	@Test
	void test3() {
		Point point = Point.first(true);
		assertThat(point.nextPoint(() -> true)).isFalse();
		assertThat(point.nextPoint(() -> false)).isFalse();
	}

	@DisplayName("이전 좌표가 false일 때, 다음 좌표를 구한다.")
	@Test
	void test4() {
		Point point = Point.first(false);
		assertThat(point.nextPoint(() -> true)).isTrue();
		assertThat(point.nextPoint(() -> false)).isFalse();
	}

	@DisplayName("좌표 객체는 매번 새로운 객체를 반환하지 않고 캐싱한다.")
	@CsvSource(value = {"true,false", "false,true", "false,false"})
	@ParameterizedTest
	void test5(boolean first, boolean next) {
		Point point = Point.first(first).next(next);
		assertThat(point == Point.first(first).next(next)).isTrue();
	}
}
