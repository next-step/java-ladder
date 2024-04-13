package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;

public class LadderTest {
	@Test
	@DisplayName("입력된 height 만큼 사다리 길이를 만든다")
	void 사다리를_생성한다() {
		final Height height = new Height(5);
		final Ladder ladder = new Ladder(4, height);

		assertThat(ladder.getLines()).hasSize(5);
	}

	@Test
	@DisplayName("height가 음수일 경우 사다리 생성 실패")
	void 사다리를_생성을_실패한다() {
		assertThatThrownBy(() -> new Ladder(4, new Height(-1)))
			.isInstanceOf(IllegalArgumentException.class);
	}


}
