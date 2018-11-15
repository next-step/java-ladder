package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class LadderGeneratorTest {

	@Test
	public void 사다리가_높이만큼_라인_생성() {
		final int ladderHeight = 5;
		final int playerCount = 4;

		List<Line> ladder = LadderGenerator.generate(ladderHeight, playerCount);
		assertThat(ladder).hasSize(ladderHeight);
	}
}