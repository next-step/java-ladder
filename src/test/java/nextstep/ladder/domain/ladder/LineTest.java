package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.movestrategy.RandomPointStrategy;

class LineTest {

	@DisplayName("Line 의 사이즈는 length - 1 이다.")
	@Test
	void Given_Length_Then_GenerateLadder() {
		int length = 2;
		Line line = new Line(length, new RandomPointStrategy());

		assertThat(line.getPoints()).hasSize(length - 1);
	}
}