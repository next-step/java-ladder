package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.generator.FixedPointGenerator;
import nextstep.ladder.generator.PointGenerator;

class LadderTest {
	@DisplayName("Ladder 생성시에 Point 개수를 검증한다.")
	@Test
	void create() {
		// given
		PointGenerator generator = new FixedPointGenerator();
		int width = 10;
		int height = 10;

		// when
		Ladder ladder = Ladder.create(generator, width, height);

		// then
		assertThat(ladder.getValues().size()).isEqualTo(width * height);
	}

	@DisplayName("point list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<Point> emptyPoints = Collections.emptyList();

		// when then
		assertAll(
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(null)),
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(emptyPoints))
		);
	}

	@DisplayName("사다리의 라인이 겹쳐져 있으면 예외 발생")
	@ParameterizedTest(name = "{index}. points : {0}")
	@MethodSource("providePoints")
	void validateOverlap(List<Point> points) {
		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Ladder.create(points));
	}

	private static Stream<Arguments> providePoints() {
		return Stream.of(
			arguments(createPoints(false, false, true, true)),
			arguments(createPoints(false, true, true, false)),
			arguments(createPoints(true, true, false, false))
		);
	}

	private static List<Point> createPoints(boolean... hasLines) {
		List<Point> points = new ArrayList<>();
		for (boolean hasLine : hasLines) {
			points.add(Point.create(hasLine));
		}
		return points;
	}
}
