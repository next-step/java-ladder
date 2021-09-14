package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.exception.MinimumLadderHeightException;

class LadderTest {
	@DisplayName(value = "사다리 높이가 1보다 낮으면 에외를 던짐")
	@Test
	void checkLadderHeight() {
		assertThatThrownBy(() -> new Ladder(3, 0))
			.isInstanceOf(MinimumLadderHeightException.class);
	}

}