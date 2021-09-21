package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.strategy.LineRandomStrategy;
import nextstep.ladder.exception.MinimumLadderHeightException;

class LadderTest {
	@DisplayName(value = "사다리 높이가 1보다 낮으면 에외를 던짐")
	@Test
	void checkLadderHeight() {
		assertThatThrownBy(() -> new Ladder(3, 0, new LineRandomStrategy()))
			.isInstanceOf(MinimumLadderHeightException.class);
	}

	@DisplayName(value = "사다리 생성")
	@Test
	void create() {
		Ladder ladder = new Ladder(3, 5, new LineRandomStrategy());
		int width = 2;
		int height = 5;

		assertThat(ladder.getLines().get(0).getPoints().size()).isEqualTo(width);
		assertThat(ladder.getLines().size()).isEqualTo(height);
	}
}