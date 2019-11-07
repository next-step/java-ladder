package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

	@Test
	void 사다리를_그리면_수평_수직으로_연결된다() {
		/* 기대하고 있는 사다리 모양
		 * |-----|     |
		 * |-----|     |
		 * |-----|     |
		 */
		// given
		Line line1 = Line.of(3);
		Line line2 = Line.of(3);
		Line line3 = Line.of(3);
		line1.makeStepWithAdjacentLine(line2, () -> true);
		line2.makeStepWithAdjacentLine(line3, () -> true);
		Ladder expectedLadder = Ladder.of(Arrays.asList(line1, line2, line3));

		// when
		Ladder createdLadder = Ladder.of(() -> true, 3, 3);

		// then
		assertThat(createdLadder).isEqualTo(expectedLadder);
	}

}
