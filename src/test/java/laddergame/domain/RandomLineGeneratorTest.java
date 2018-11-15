package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class RandomLineGeneratorTest {

	@Test
	public void 사람수만큼_라인_생성() {
		final int playerCount = 4;

		List<Boolean> points = RandomLineGenerator.generate(playerCount);

		assertThat(points).hasSize(playerCount);
	}
}