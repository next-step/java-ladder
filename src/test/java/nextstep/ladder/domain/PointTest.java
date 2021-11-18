package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {
	@DisplayName("Point 생성을 검증한다.")
	@ParameterizedTest(name = "{index}. hasLine : {0}")
	@ValueSource(booleans = {false, true})
	void create(boolean hasLine) {
		// when
		Point point = Point.create(hasLine);

		// then
		assertThat(point.hasLine()).isEqualTo(hasLine);
	}

	@DisplayName("이전 Point 의 정보를 계산하여 새로운 포인트를 생성한다.")
	@ParameterizedTest(name = "{index}. targetPoint : {0}, targetPoint : {1}, expected : {2}")
	@MethodSource("providePoint")
	void calculatePrev(Point targetPoint, Point prevPoint, boolean expected) {
		// when
		Point result = targetPoint.calculatePrev(prevPoint);

		// then
		assertThat(result.hasLine()).isEqualTo(expected);
	}

	private static Stream<Arguments> providePoint() {
		return Stream.of(
			arguments(Point.create(false), Point.create(false), false),
			arguments(Point.create(false), Point.create(true), false),
			arguments(Point.create(true), Point.create(false), true),
			arguments(Point.create(true), Point.create(true), false)
		);
	}
}
