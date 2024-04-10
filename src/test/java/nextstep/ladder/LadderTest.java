package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Ladder;

public class LadderTest {
	@Test
	void 사다리를_생성한다() {
		final Ladder ladder = new Ladder(4, 5);

		assertThat(ladder.getLines()).hasSize(5);
	}
}
