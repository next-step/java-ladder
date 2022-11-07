package nextstep.ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

	@Test
	void 사용자가_입력한_만큼_사다리의_층을_만든다() {
		Ladder ladder = new Ladder(5, 4);
		assertThat(ladder.numberOfFloors()).isEqualTo(5);
	}

}
