package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;

public class RowTest {
	@DisplayName("사다리 폭을 초과하여 이동할 수 없습니다.")
	@ParameterizedTest
	@MethodSource("rows1")
	void validate_move_in_width(List<Point> points) {
		assertThatThrownBy(() -> new Row(points))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("사다리 폭을 초과하여 이동할 수 없습니다.");
	}

	static Stream<Arguments> rows1() {
		return Stream.of(
			Arguments.arguments(List.of(Point.LEFT, Point.HOLD, Point.HOLD)),
			Arguments.arguments(List.of(Point.HOLD, Point.HOLD, Point.RIGHT))
		);
	}

	@DisplayName("수평 이동선 생성에 문제가 있는지 확인합니다.")
	@ParameterizedTest
	@MethodSource("rows2")
	void validate_can_move_other_line(List<Point> points) {
		assertThatThrownBy(() -> new Row(points))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("수평 이동선 생성에 문제가 있습니다.");
	}

	static Stream<Arguments> rows2() {
		return Stream.of(
			Arguments.arguments(List.of(Point.RIGHT, Point.HOLD, Point.LEFT, Point.HOLD, Point.LEFT)),
			Arguments.arguments(List.of(Point.RIGHT, Point.RIGHT, Point.RIGHT, Point.HOLD, Point.LEFT))
		);
	}
}
