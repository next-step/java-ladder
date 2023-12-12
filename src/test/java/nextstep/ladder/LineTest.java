package nextstep.ladder;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.strategy.FirstLineGenerator;
import nextstep.ladder.domain.strategy.LastLineGenerator;
import nextstep.ladder.domain.strategy.MiddleLineGenerator;

public class LineTest {
	@DisplayName("첫번째 줄을 좌측 포인트를 가지지 않습니다.")
	@Test
	void validate_generate_first_line() {
		Line line = new Line(new FirstLineGenerator(new Height(5)));
		for (Point point : line.points()) {
			Assertions.assertThat(point).isNotEqualTo(Point.LEFT);
		}
	}

	@DisplayName("두번째 이상의 줄은 이전 줄에 대응하여 생성됩니다.")
	@Test
	void validate_generate_middle_line() {
		Line line = new Line(new MiddleLineGenerator(List.of(Point.LEFT, Point.DOWN, Point.RIGHT, Point.RIGHT, Point.DOWN)));
		Assertions.assertThat(line.points().get(2)).isEqualTo(Point.LEFT);
		Assertions.assertThat(line.points().get(3)).isEqualTo(Point.LEFT);
	}

	@DisplayName("마지막 줄은 우측 포인트를 가지지 않습니다.")
	@Test
	void validate_generate_last_line() {
		Line line = new Line(new LastLineGenerator(List.of(Point.RIGHT, Point.DOWN, Point.RIGHT, Point.DOWN, Point.DOWN)));
		for (Point point : line.points()) {
			Assertions.assertThat(point).isNotEqualTo(Point.RIGHT);
		}
	}
}
