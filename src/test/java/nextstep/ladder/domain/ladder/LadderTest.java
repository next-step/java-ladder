package nextstep.ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.linestrategy.RandomLineGenerator;

class LadderTest {

	@DisplayName("ladder 의 사이즈는 height 이다.")
	@Test
	void Given_Height_Then_GenerateLadder() {
		int height = 2;
		Ladder ladder = new Ladder(1, height, new RandomLineGenerator());

		assertThat(ladder.getLadder()).hasSize(height);
	}
}