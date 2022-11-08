package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by seungwoo.song on 2022-11-04
 */
class LadderLineTest {

	@Test
	void 생성() {
		int personCount = 2;
		LadderLine ladderLine = LadderLine.of(personCount, () -> true);
		assertThat(ladderLine).isEqualTo(LadderLine.of(personCount, () -> true));
	}

	@Test
	void 이동() {
		int personCount = 2;
		int index = 0;

		LadderLine ladderLine = LadderLine.of(personCount, () -> true);
		assertThat(ladderLine.move(index)).isEqualTo(1);
	}
}
