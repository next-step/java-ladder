package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

	@DisplayName("Line 의 사이즈는 length - 1 이다.")
	@Test
	void Given_Length_Then_GenerateLadder() {
		int length = 2;
		Line line = new Line(length);

		assertThat(line).hasSize(length - 1);
	}
}