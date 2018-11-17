package laddergame.domain;

import static java.util.Arrays.asList;
import static laddergame.domain.Direction.LEFT;
import static laddergame.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LineTest {

	@Test
	public void 라인_문자열_생성() {
		Line line = Line.from(
				asList(Point.from(RIGHT), Point.from(LEFT), Point.from(RIGHT), Point.from(LEFT))
		);

		assertThat(line.draw()).isEqualTo("     |-----|     |-----|");
	}
}
