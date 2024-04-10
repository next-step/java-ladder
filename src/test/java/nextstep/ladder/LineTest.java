package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.RandomGenerator;

public class LineTest {

	@Test
	void 라인_생성_테스트() {
		final int numberOfPeople = 4;
		final Line line = new Line(numberOfPeople);
		assertThat(line.getPoints()).hasSize(3);
	}
}
